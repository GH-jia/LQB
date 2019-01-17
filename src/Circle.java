import java.util.Scanner;

import static java.lang.Math.atan;

public class Circle {
    int r;
    static double PI = atan(1.0)*4;
    public void getArea(){
        Scanner in = new Scanner(System.in);
        r = in.nextInt();
        double area = r*r*PI;
        System.out.println(String.format("%.7f",area));
    }

}
