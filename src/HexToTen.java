import java.util.Scanner;

/**
 * Conver hex to ten
 */
public class HexToTen {
    public void start(){
        Scanner in = new Scanner(System.in);
        String str = in.next();

//        int[] tenArray = new int[str.length()];
//        for (int i=0;i<str.length();i++){
//            char numHex = str.charAt(i);
//
//        }
        long numTen = Long.valueOf(str,16);
        System.out.println(numTen);
        in.close();
    }
}
