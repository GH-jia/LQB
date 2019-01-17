import java.util.Scanner;

public class xulie {
    long n=0,result=0;
    void display(){
        long consum = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int i;
        if(n<10)
            for(i=1;i<10;i++){
                result+=i;
            }
        else{
            long a = n/10;
            int b = (int) (n%10);
            int t=0;
            for(i = 1;i<=9;i++)
                t += i;
            for(i=1;i<=b;i++)
                result += i;
            for(i=1;i<=a;i++)
                result += 10*i;
            result += t*(a);
            for(i=1;i<=a-1;i++)
                result+=9*10*i;
            result += b*10*a;
        }
        System.out.println(result);
        System.out.println("consuming : "+(System.currentTimeMillis()-consum)/1000f+"秒");
    }
}
