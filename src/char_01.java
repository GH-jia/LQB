public class char_01 {
    public void start(){
        String s;
        for (int i=0; i<32;i++){
            s = Integer.toString(i,2);
            if (s.length() == 1) s = "0000"+s;
            if (s.length() == 2) s = "000"+s;
            if (s.length() == 3) s = "00"+s;
            if (s.length() == 4) s = "0"+s;
            System.out.println(s);
        }
    }
}
