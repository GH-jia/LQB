import java.util.Scanner;

public class xulie {
    long n=0,result=0;
    void display(){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        long consum = System.currentTimeMillis();
        result = (1+n)*n/2;
        System.out.println(result);
        System.out.println("consuming : "+(System.currentTimeMillis()-consum)/1000f+"秒");
    }
}
