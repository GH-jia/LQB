/**
 * Convert hex to octal
 */

import java.util.Scanner;

public class SixteenToEight {
    public void start() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] result = new String[n];
        for (int i=0;i<n;i++ ){
            String numH = in.next();

            StringBuilder strB = new StringBuilder();
            for (int j=0;j<numH.length();j++){
                char chrnumH = numH.charAt(j);
                String numB = Integer.toBinaryString(Integer.valueOf(String.valueOf(chrnumH),16));
                if (numB.length()%4 == 1) numB = "000"+numB;
                if (numB.length()%4 == 2) numB = "00"+numB;
                if (numB.length()%4 == 3) numB = "0"+numB;
                strB.append(numB);
            }

            String numB = strB.toString();
            if (numB.length()%3 == 1) numB = "00"+numB;
            if (numB.length()%3 == 2) numB = "0"+numB;
            StringBuilder strO = new StringBuilder();
            for (int j=0;j<numB.length();j+=3){
                String numO = Integer.toOctalString(Integer.valueOf(numB.substring(j,j+3),2));
                strO.append(numO);
            }
            result[i] = strO.toString().replaceAll("^(0+)","");//bug:如果十六进制为0，则转为八进制后也为0，但是经过取前导零后，就会输出“”

        }
        for (int i=0;i<n;i++){
            System.out.println(result[i]);
        }
    }



}
