import java.util.Scanner;

public class Bubble_sort {
    void sort(int[] array){
        int i=0,j=0;
        for(i = array.length-1;i>0;i--){
            for (j=0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    array[j] = array[j]^array[j+1];
                    array[j+1] = array[j] ^array[j+1];
                    array[j] = array[j] ^ array[j+1];
                }
            }
        }
        for (int a:array)
            System.out.print(a+" ");
        System.out.println();
    }

    /**
     * 有时候发现我想输入的in.nextLine()并没有给我输入的机会。为啥？问题解释：
     * 首先，你需要知道in.nextLine();不能放在in.nextInt();代码段后面。
     * 其实，他不是跳过你了，而是他已经有内容了，内容就是‘\n’。因为nextInt();接收一个整型字符,不会读取\n，nextline();读入一行文本，会读入"\n"字符。解决方法：
     * 可以在nextInt();和nextLine();中间加一个in.nextLine();语句来接收这个"\n"
     */
    public void input(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.nextLine();
        str = in.nextLine();
        String[] strArray = str.split(" ");
        int[] intArray = new int[n];
        for (int i=0;i<n;i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        sort(intArray);
    }
}
