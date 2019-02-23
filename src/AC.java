import javax.swing.tree.TreeNode;
import java.util.*;

public class AC {

    //只处理英文类型的字符串，所以数组的长度是128
    private  static final  int ASCLL = 128;

    //内部静态类，用于表示AC自动机的每个节点，在每个节点中我们并没有存储该节点对应的字
    private static class Node{
//        如果该节点是一个终点，则从根节点到此节点表示了一个目标字符串，则str != null, 且str就表示该字符串
        String str;
        Node[] table = new Node[ASCLL];
//        当前节点的孩子节点不能匹配文本串中的某个字符时，下一个应该查找的节点
        Node fail;
        public boolean isWord(){
            return str != null;
        }
    }

    //AC自动机的根节点，根节点不存储任何字符信息
    private  Node root;

    //待查找的目标字符串集合,为什么不用String[]
    private List<String> target;

    //表示在文本字符串中查找的结果，key表示目标字符串，value表示目标字符串在文本串中出现的位置
    private HashMap<String,List<Integer>> result;

    public AC(List<String> target){
        root = new Node();
        this.target = target;
        buildTrieTree();
        build_AC_FromTrie();
    }
    public AC(){}

    //由目标字符串构建Trie树
    private void buildTrieTree(){
        for (String targetStr : target){
            Node curr = root;
            for (int i=0,len=targetStr.length();i<len;i++){
                char ch = targetStr.charAt(i);
                if (curr.table[ch] == null){
                    curr.table[ch] = new Node();
                }
                curr = curr.table[ch];
            }
            curr.str = targetStr;
        }
    }

    //由Trie树构建AC自动机，本质是一个自动机，相当于构建KMP算法的next数组
    private void build_AC_FromTrie(){
        //广度优先遍历所使用的队列
        LinkedList<Node> queue = new LinkedList<Node>();
        //单独处理根节点的所以孩子节点
        for (Node x : root.table){
            if (x!=null){
                //根节点的所有孩子节点的fial都指向根节点
                x.fail = root;
                //所有根节点的孩子节点入列
                queue.addLast(x);
            }
        }
        while(!queue.isEmpty()){
            //确定出列节点的所有孩子节点的fail的指向
            Node p = queue.removeFirst();
            for (int i=0,len=p.table.length;i<len;i++){
                if (p.table[i] != null){
                    //孩子节点入列
                    queue.addLast(p.table[i]);
                    //从p.fail开始找起
                    Node failTo = p.fail;
                    while(true){
                        //说明找到了根节点还没找到
                        if (failTo == null){
                            p.table[i].fail = root;
                            break;
                        }
                        if (failTo.table[i] != null){
                            p.table[i].fail = failTo.table[i];
                            break;
                        }
                        else {
                            failTo = failTo.fail;
                        }
                    }
                }
            }
        }
    }

    //在文本串中查找所有的目标字符串
    public HashMap<String,List<Integer>> find(String text){
        //创建一个表示存储结果的对象
        result = new HashMap<String, List<Integer>>();
        for (String s : target){
             result.put(s,new LinkedList<Integer>());
        }
        Node curr = root;
        int i=0;
        int len = text.length();
        while(i<len){
            char ch = text.charAt(i);
            //文本串中的字符和AC自动机中的字符进行比较
            if (curr.table[ch] != null){
                //若相等，自动机进入下一状态
                curr = curr.table[ch];
                if (curr.isWord()){
                    result.get(curr.str).add(i-curr.str.length()+1);
                }
                /**
                 * 这里很容易被忽视，因为一个目标串的中间某部分字符串可能正好包含另一个目标字符串，
                 * 即使当前节点不表示一个目标字符串的终点，但到当前节点为止可能恰好包含了一个字符串
                 */
                if (curr.fail != null && curr.fail.isWord()){
                    result.get(curr.fail.str).add(i-curr.fail.str.length()+1);
                }
                //索引自增，指向文本串中的下一个字符
                i++;
            }
            else {
                //若不等,找到下一个应该比较的状态
                curr = curr.fail;
                //到根节点还未找到，说明文本串中以ch作为结束的字符片段不是任何目标字符串的前缀，状态机重置，比较下一个字符
                if (curr == null){
                    curr = root;
                    i++;
                }
            }
        }
        return result;
    }

    public static void start(){
        List<String> target = new ArrayList<String>();
        target.add("abcdef");
        target.add("abhab");
        target.add("bcb");
        target.add("cdfkcdf");
        String text = "bcabcdebcedfabcdefababkabhabk";
        AC aca = new AC(target);
        HashMap<String,List<Integer>> result = aca.find(text);
        System.out.println(text);
        for (Map.Entry<String , List<Integer>> entry : result.entrySet()){
            System.out.println(entry.getKey()+"："+ entry.getValue());
        }
    }
}
