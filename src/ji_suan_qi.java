import java.math.BigInteger;
import java.util.Scanner;

public class ji_suan_qi {
    private int k=10;//表示当前进制
    //因为2^63较大，所有使用BigInterger
    private BigInteger result = BigInteger.valueOf(0);
    private BigInteger num = BigInteger.valueOf(0);
    private String[] order;
    public void start(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.nextLine();//接受nextInt多余的”\n“

//        接收指令
        order = new String[n];
        for (int i=0;i<n;i++){
            order[i] = in.nextLine();
        }

//        处理指令
        for (int i=0;i<n;i++){
            String[] orderArray = order[i].split(" ");
            if ("NUM".equals(orderArray[0])) {
                //首先转换为十进制
                num = new BigInteger(orderArray[1],k);
                System.out.println("num="+num.toString(10));
                result = num;
                System.out.println("result="+result.toString(10));
                continue;
            }
            else if ("ADD".equals(orderArray[0])) {
                //检测到运算指令，则i+1跳到下一条指令接收NUM
                i = jieshou(i);
                result = result.add(num);
                System.out.println("result="+result.toString(10));
                continue;
            }
            else if ("SUB".equals(orderArray[0])) {
                //检测到运算指令，则i+1跳到下一条指令接收NUM
                i = jieshou(i);
                result = result.subtract(num);
                continue;
            }
            else if ("MUL".equals(orderArray[0])) {
                //检测到运算指令，则i+1跳到下一条指令接收NUM
                i = jieshou(i);
                result = result.multiply(num);
                continue;
            }
            else if ("DIV".equals(orderArray[0])) {
                //检测到运算指令，则i+1跳到下一条指令接收NUM
                i = jieshou(i);
                result = result.divide(num);
                continue;
            }
            else if ("MOD".equals(orderArray[0])) {
                //检测到运算指令，则i+1跳到下一条指令接收NUM
                i = jieshou(i);
                result = result.remainder(num);
                continue;
            }
            else if ("CHANGE".equals(orderArray[0])) {
                k = Integer.parseInt(orderArray[1]);
                System.out.println("k="+k);
            }
            else if ("EQUAL".equals(orderArray[0])) {
                String str = result.toString(k);
                str = str.toUpperCase();
                System.out.println(str);
            }
            else if ("CLEAR".equals(orderArray[0])) {
                result= BigInteger.valueOf(0);
            }

        }
    }
    public int jieshou(int i){
        i++;
        String[] orderArray = order[i].split(" ");
        if ("NUM".equals(orderArray[0])){
            //首先转换为十进制,并赋值给num
            num = new BigInteger(orderArray[1],k);
        }
        else if ("CHANGE".equals(orderArray[0])) {
            k = Integer.parseInt(orderArray[1]);
            i++;
            orderArray = order[i].split(" ");
            if ("NUM".equals(orderArray[0])){
                //首先转换为十进制,并赋值给num
                num = new BigInteger(orderArray[1],k);
            }
        }
        System.out.println("num="+num.toString(10));
        return i;
    }

}
