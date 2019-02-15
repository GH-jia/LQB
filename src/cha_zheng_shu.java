import java.util.Scanner;

public class cha_zheng_shu {
    public void start(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String aa = in.nextLine();
        String num = in.nextLine();
        //aa = in.nextLine();
        int search = in.nextInt();
        in.close();
        int result = -1;
        String[] numArray = num.split(" ");
        for (int i=0;i<n;i++){
            if (search == Integer.parseInt(numArray[i])){
                result = i+1;
                break;
            }

        }
        System.out.println(result);


    }
}
