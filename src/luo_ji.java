import java.util.Scanner;

public class luo_ji {
    public void start(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strAraay = str.split(" ");
        int n = Integer.parseInt(strAraay[0]);
        int m = Integer.parseInt(strAraay[1]);
        int[] a = new int[n];

//       输入矩阵
        String num;
        for (int i=0;i<n;i++){
            for (int j=m;j>0;j--){
                num = in.next();
                a[i] += Integer.parseInt(num)*Math.pow(2,j);
            }
        }

        int acount=0;
//        for (int i=0;i<n;i++){
//            for (int j=0;j<n;j++){
//                for (int k=0;k<m;k++){
//                    if (a[i][k] == a[j][k])
//                        break;
//                    else if (k==m-1)
//                        acount++;
//                }
//            }
//        }
        for (int k=0;k<n;k++){
            for (int j=0;j<n;j++){
                if ((a[k]&a[j]) == 0){
                    acount++;
                }
            }
        }

        System.out.println(acount/2);

    }
}
