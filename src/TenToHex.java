import java.util.Scanner;

public class TenToHex {
    public void start(){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String numHex = Integer.toHexString(a);
        System.out.println(numHex.toUpperCase());
        in.close();
    }
}
