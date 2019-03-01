import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class n个不同硬币能否凑出m元问题 {
//    一元有两枚，3元有3枚，五元有4枚
//    能凑出几种总金额
//    public static HashMap<Integer,Integer> resultF2 = new HashMap<Integer, Integer>();
    public void f1(int[][] yuan){
        //        新方法一
//        缺陷：
//        必须要有一元面额的硬币，yuan数组要按硬币从小到大排序

        //        计算程序运行时间开始
        long startTime=System.nanoTime();
        int max=0;
        for (int i=0,len=yuan.length;i<len;i++){
            max += yuan[i][0]*yuan[i][1];
        }
        int[] result = new int[max];
        for (int i=1,j=0;i<=max;i++){
            int q = i/yuan[2][0];
            int r = i%yuan[2][0];
            if (q<=4 && r==0){
                result[j] = i;
                j++;
                continue;
            }
            else {
                int y = q-yuan[2][1]>=0 ? q-yuan[2][1]:0;
                int t = y*yuan[2][0]+r;
                q = t/yuan[1][0];
                r = t%yuan[1][0];
                if (q<=3 && r==0){
                    result[j] = i;
                    j++;
                    continue;
                }
                else {
                    y = q-yuan[1][1]>=0 ? q-yuan[1][1]:0;
                    t = y*yuan[1][0]+r;
                    q = t/yuan[0][0];
                    r = t%yuan[0][0];
                    if (q<=3 && r==0){
                        result[j] = i;
                        j++;
                        continue;
                    }
                }
            }
        }
        long endTime=System.nanoTime();    //获取程序结束时间
        System.out.println("新方法一运行时间：" + (endTime - startTime) + "ns");
        System.out.println("新方法一结果：");
        for (int i : result){
            System.out.print(i+" ");
        }
        System.out.println();

    }
    public void f2(int[][] yuan){
        //每一个硬币作为一个节点构建树，深度遍历
        //该方法不正确，有待改进
        long startTime = System.nanoTime(); //获取程序开始时间

        HashMap<Integer,Integer> result = new HashMap<Integer, Integer>();
//        i,j,k用于设置遍历临界值
        int i = yuan[0][1];
        int j = yuan[1][1];
        int k = yuan[2][1];
        int sum=0;//用于临时保存结果
        digui(i,j,k,result,yuan,sum);

        long endTime=System.nanoTime();    //获取程序结束时间
        System.out.println("新方法二运行时间：" + (endTime - startTime) + "ns");

        System.out.println("新方法二结果：");
        //        为了方便比对，对hashmap的key排序
        int[] last = new int[result.size()];
        i=0;
        for (int key : result.keySet()){
            last[i] = key;
            i++;
        }
        insertSort(last);
        j=0;
        for (int len=last.length;j<len;j++){
            System.out.print(last[j]+" ");
        }

    }
    public void digui(int i,int j,int k,HashMap<Integer,Integer> result,int[][] yuan,int sum){
        if (i>0){
            int sum_i = sum;
            sum_i += yuan[0][0];
            if (!result.containsKey(sum_i)){
                result.put(sum_i,0);
                digui(i-1,j,k,result,yuan,sum_i);
            }

        }
        if (j>0){
            int sum_j = sum;
            sum_j += yuan[1][0];
            if (!result.containsKey(sum_j)){
                result.put(sum_j,0);
                digui(i,j-1,k,result,yuan,sum_j);
            }
        }
        if (k>0){
            int sum_k = sum;
            sum_k += yuan[2][1];
            if (!result.containsKey(sum_k)){
                result.put(sum_k,0);
                digui(i,j,k-1,result,yuan,sum_k);
            }
        }
    }

    public void old(int[][] yuan){
//        计算程序运行时间开始
        long startTime = System.nanoTime();
        //        旧方法
        HashMap<Integer,Integer> result1 = new HashMap<Integer, Integer>();
        for (int i=0;i<=yuan[0][1];i++){
            for (int j=0;j<=yuan[1][1];j++){
                for (int k=0;k<=yuan[2][1];k++){
                    int sum = i*yuan[0][0]+j*yuan[1][0]+k*yuan[2][0];
                    if (!result1.containsKey(sum)){
                        result1.put(sum,0);
                    }
                }
            }
        }
        long endTime=System.nanoTime();    //获取程序结束时间
        System.out.println("旧方法一运行时间：" + (endTime - startTime) + "ns");
//        为了方便比对，对hashmap的key排序
        int[] last = new int[result1.size()];
        int i=0;
        for (int key : result1.keySet()){
            last[i] = key;
            i++;
        }
        insertSort(last);
//        因为不需要0，所以从last[1]开始输出
        System.out.println("旧方法结果：");
        for (int j=1,len=last.length;j<len;j++){
            System.out.print(last[j]+" ");
        }
    }
    public void start(){
        int[][] yuan = {{1,3},{4,4},{5,2}};
        f1(yuan);
        f2(yuan);
        old(yuan);
    }
    public static void main(String[] args){
       new n个不同硬币能否凑出m元问题().start();

    }
    public static void insertSort(int[] arr){
        int preIndex;
        for (int i=1,len=arr.length;i<len;i++){
            preIndex = i-1;
            int current = arr[i];
            while (preIndex >=0 && arr[preIndex]>arr[i]){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
    }
}
