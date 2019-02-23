import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dynamic {
    /**
     * 动态规划：国王和金矿
     * 10个工人最多可以得到多少黄金
     * 一个金矿要么开采，要么不开采。例如：500金/5人金矿需要5人才能开采，3名工人不能开采
     * 五个金矿黄金量与所需工人数：500金/5人，200金/3人，300金/4人，350金/3人，400金/5人
     */
    private int n =4;//金矿数
    private int w = 10;//工人数
    private int[][] g = {{500,5},{200,3},{300,4},{350,3},{400,5}};
    private int result;

    class Memo {
       public int n;
       public int w;
    }

    private HashMap<Memo,Integer> memo = new HashMap<Memo, Integer>();

    private int findResult(Memo m,int[][] g){
        if (m.n==0 ){
            if (m.w >= g[0][1]){
                return g[0][0];
            }
            return 0;
        }

        Memo mL = new Memo();
        mL.n = m.n-1;
        mL.w = m.w;

        Memo mR = new Memo();
        mR.n = m.n-1;
        mR.w = m.w-g[m.n][1];

        if (!memo.containsKey(mL)){
            int a = findResult(mL,g);
            memo.put(mL,a);
        }
        if (!memo.containsKey(mR)){
            int a = findResult(mR,g);
            memo.put(mR,a);
        }

        int left = memo.get(mL);
        int right = memo.get(mR);
        int r;
        if (left==0 && right ==0){
            r=0;
        }
        else {
            r = Math.max(left,right+g[m.n][0]);
        }

        return r;

    }

    public void start(){
        Memo m = new Memo();
        m.n = this.n;
        m.w = this.w;
        result = findResult(m,g);
        System.out.println(result);

        Iterator<Map.Entry<Memo, Integer>> iterator = memo.entrySet().iterator();
        System.out.println("n:w ---> value");
        while (iterator.hasNext()) {

            Map.Entry<Memo, Integer> entry = iterator.next();

            Memo key = entry.getKey();

            Integer value = entry.getValue();

            System.out.print(key.n+":"+key.w+ " ---> " + value);

            System.out.println();

        }




    }


}
