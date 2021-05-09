import java.util.Scanner;

public class Permute {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter text for permute:");

        String inStr = sc.nextLine();
        permute2(inStr,"");
    }

    public static void permute(String inStr, String ans){
        if(inStr.length() == 0){
            System.out.println(ans + "");
        } else{
            for(int pos=0; pos<inStr.length();pos++){
                char c = inStr.charAt(pos);
                String ros = inStr.substring(0,pos) + inStr.substring(pos+1) ;
                permute(ros, ans + c);
            }
        }
    }
    public static void permute2(String s1, String s2){
        if(s1.length() ==0){
            System.out.println(s2+"");
        } else {
            for(int i=0;i<s1.length(); i++){
                char c = s1.charAt(i);
                String ro = s1.substring(0,i) + s1.substring(i+1);
                permute2(ro,s2+c);
            }
        }
    }
/*

    public static void permute3(String s1, String s2){
        if()
    }
*/
}
