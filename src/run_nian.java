import java.util.Scanner;

public class run_nian {
    public void start(){
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        if(year%4 == 0 && year%100 != 0)
            System.out.println("yes" );
        else if (year%400 == 0)
            System.out.println("yes" );
        else
            System.out.println("no");
    }
}
