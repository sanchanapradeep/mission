import scala.Char;

import java.net.SocketOption;
import java.util.HashMap;
import java.util.Scanner;

public class Annogram {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String s1 = sc.next();
        String s2 = sc.next();

        /*if(isAnnogram2(s1,s2) == true){
            System.out.println( s1 +" and "+ s2 + " are annogram");
        } else {
            System.out.println(s1 +"," +s2 +"are NOT ");
        }*/
        System.out.println(makeAnagram(s1,s2));
    }
    public static boolean isAnnogram( String s1, String s2){
        HashMap<Character,Integer> h1 = new HashMap<>();
        for(char c : s1.toCharArray()){

            if( h1.get(c) == null) {
                h1.put(c, 1);
            } else {
                int number = h1.get(c).intValue();
                h1.put(c,number+1);
            }
        }
        for(char c : s2.toCharArray()){

            if(h1.get(c) == null ) {
                return false;
            } else {
                int count1 = h1.get(c).intValue();
                if(count1 == 1){
                    h1.remove(c);
                } else {
                    h1.put(c, count1-1);
                }
            }
        }
        if(h1.isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean isAnnogram2 (String s1, String s2) {
        int[] count = new int[256];
        if(s1.length() != s2.length()) {
            return false;
        }

        for(int len =0; len< s1.length(); len++) {
            count[s1.charAt(len)-'a'] ++;
            count[s2.charAt(len)-'a']--;
        }
        for(int i=0; i<256; i++){
            if(count[i]!=0)
                return false;
        }
        return true;
    }
    public static int makeAnagram(String a, String b) {
        // Write your code here

        int arr[] = new int[26];
        for(int i=0;i<a.length(); i++){
            arr[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length(); i++){
            arr[b.charAt(i)-'a']--;
        }
        int res=0;
        for(int i=0;i<26; i++){
            if(arr[i]!=0){
                res++;
            }
        }
        return res;

    }

}
