import java.util.Scanner;

/**
 * 特殊回文数
 * 分别找五位数和六位数
 */
public class teShuHuiWenShu {
    public void start(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        //五位数
        for (int i=1;i<10;i++){
            for (int j=0;j<10;j++){
                for (int k=0;k<10;k++){
                    if(n==i*2+j*2+k)
                        System.out.println(i*10000+j*1000+k*100+j*10+i);
                }
            }
        }

        //六位数
        for (int i=1;i<10;i++){
            for (int j=0;j<10;j++){
                for (int k=0;k<10;k++){
                    if(n==i*2+j*2+k*2)
                        System.out.println(i*100000+j*10000+k*1000+k*100+j*10+i);
                }
            }
        }

        in.close();
    }
}
