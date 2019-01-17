import java.util.Scanner;

public class AB {
    public void sum(){
        int a,b;
        String str;
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        String[] strArray = str.split(" ");
        a = Integer.parseInt(strArray[0]);
        b = Integer.parseInt(strArray[1]);
        System.out.println(a+b);
    }
}
