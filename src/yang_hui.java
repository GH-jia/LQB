/**
 * 打印杨辉三角
 */

import java.util.Scanner;

public class yang_hui {
    public void start(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] up = new int[n];//保存上一行
        for (int i=0;i<n;i++){
            int[] a = new int[n];//保存当前行
            //打印第i+1行，i=0时为第一行
            for (int j=0;j<=i;j++){
                if (j ==0 || j==i){
                    System.out.print(1);
                    a[0]=a[i]=1;
                }else{
                    System.out.print(up[j]+up[j-1]);
                    a[j] = up[j]+up[j-1];
                }
                System.out.print(" ");
            }
            System.out.println();
            for (int k=0;k<n;k++){
                up[k] = a[k];
            }
        }
    }
    public void yangHui2(){
        /**
         * 杨辉三角还可以使用二维数组解决，原理与上述的一维数组相同。
         * 下述方法的解决思路与一维数组解法不同；
         *
         */
        int rows = 10;

        for(int i =0;i<rows;i++) {
            int number = 1;
            //打印空格字符串
            System.out.format("%"+(rows-i)*2+"s","");
            for(int j=0;j<=i;j++) {
                System.out.format("%4d",number);
                number = number * (i - j) / (j + 1);
                //number = number * (i+1-(j+1))/(j+1)
            }
            System.out.println();
        }
    }
}

