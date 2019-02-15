import java.util.Scanner;

public class input_founction {
    public void f1(){
        /**
         * 利用以下方法可以实现输入：
         * 2 2
         * 3 4
         * 这种矩阵型数据
         */
        Scanner in = new Scanner(System.in);
        int[][] a = new int[2][2];
        String str;
        for (int i=0;i<2;i++)
            for (int j=0;j<2;j++){
                str = in.next();
                a[i][j] = Integer.parseInt(str);
            }
        for (int i=0;i<2;i++)
            for (int j=0;j<2;j++){
                System.out.println(a[i][j]);
            }

    }
}
