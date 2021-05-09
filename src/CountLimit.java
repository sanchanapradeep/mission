import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountLimit {

    // Complete the makeAnagram function below.
    static int makeAnagram(int[] a, int b) {
        Arrays.sort(a);
        int sum =0;
        int i=0;
        for(;i<a.length&& sum <b; ++i){
            sum += a[i];
        }
        return i-1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] a = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int count = Integer.parseInt(a[0]);
        int money = Integer.parseInt(a[1]);
        int arr[] = new int[count];

        for (int i = 0; i < n ; i++) {
            String[] b = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < count ; j++) {
                int arrItem = Integer.parseInt(b[j]);
                arr[j] = arrItem;
            }
            int res = makeAnagram(arr, money);
            //bufferedWriter.write(String.valueOf(res));
            //bufferedWriter.newLine();


        }



        //bufferedWriter.close();

        scanner.close();
    }
}
