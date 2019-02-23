public class test {

    public static void start() {
        int[] p = new int[]{3, 4, 3, 5, 5};
        int[] g = new int[]{200, 300, 350, 400, 500};
        new test().getMaxGold(5, 3, p, g);
//        System.out.println(gold);
    }

    public void getMaxGold(int n, int w, int[] p, int[] g) {
        int[] preResult = new int[w];
        int[] result = new int[w];

        for (int i = 0; i < w; i++) {
            if (i+1 < p[0]) {
                preResult[i] = 0;
            } else {
                preResult[i] = g[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < w; j++) {

                if (j+1 < p[i] ) {
                    result[j] = preResult[j];
                }else if(j+1 == p[i]){
                    result[j] = Math.max(preResult[j], preResult[j-p[i]+1] + g[i]);
                } else {
                    result[j] = Math.max(preResult[j], preResult[j - p[i]] + g[i]);
                }
            }
            show(result);
            preResult = result.clone();
        }
    }

    public void show(int[] array){
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
