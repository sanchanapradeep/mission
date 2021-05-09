import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap <Long, Long> h2 = new HashMap<Long, Long>();
        HashMap <Long, Long> h3 = new HashMap<Long, Long>();
        Long ans = Long.valueOf(0);
        for(Long e: arr){
            if(h3.get(e) != null){
                ans += h3.get(e);
            }
            if(h2.get(e) != null){
                if(h3.get(e*r) == null) {
                    h3.put(e*r, h2.get(e));
                } else{
                    h3.put(e*r, h3.get(e*r)+1L);
                }
            }
            h2.put(e*r, h2.getOrDefault(e*r,0L)+1L);
            //Long t= h2.getOrDefault(e*r,0L);

        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);
        System.out.println(String.valueOf(ans));
        //bufferedWriter.write(String.valueOf(ans));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}