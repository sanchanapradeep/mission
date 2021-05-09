import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SpecialStringAgain {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long count =n;
        long t[][] = new long[n][n];
        for (int j=0;j< n;j++) {
            t[j][j] = 1;
        }
        for(int i=1;i<n;i++){
            for (int j=0;j< n-i;j++){
                if(s.charAt(j) ==s.charAt(j+i)){
                    if(j+1 > j+i-1){
                        t[j][j+i] = 1;

                    } else {
                        if(issub(s, i,j)){
                            t[j][j+i] = t[j+1][j+i-1];
                        }
                    }
                    count += t[j][j+i];
                }
            }
        }
        return count;

    }
    static boolean issub(String s,int i,int j){
        String tmp = s.substring(j,j+i);
        for(int k=j; k<j+i/2; k++){
            if(s.charAt(j) != s.charAt(k)){
                return false;
            }
        }
        return true;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        System.out.println(result);
        scanner.close();
    }
}


