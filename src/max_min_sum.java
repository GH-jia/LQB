import java.util.Scanner;

public class max_min_sum {
    public void start(){
        int max,sum=0,min;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String aa = in.nextLine();//接收“\n”
        String numbers = in.nextLine();
        String[] numArray = numbers.split(" ");
        max = Integer.parseInt(numArray[0]);
        min = Integer.parseInt(numArray[0]);
        for (int i=0;i<numArray.length;i++){
           sum += Integer.parseInt(numArray[i]);
           if (max < Integer.parseInt(numArray[i])) max = Integer.parseInt(numArray[i]);
           if (min > Integer.parseInt(numArray[i])) min = Integer.parseInt(numArray[i]);
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);
    }
}
