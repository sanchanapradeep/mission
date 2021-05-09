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


public class FrequncyQuery {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        HashMap<Integer, Integer> h= new HashMap<>();
        List<Integer> o= new ArrayList<>();
        for(List<Integer> e: queries) {
            switch (e.get(0)) {
                case 1:
                    h.put(e.get(1), h.getOrDefault(e.get(1), 0) + 1);

                    break;
                case 2:
                    h.remove(e.get(1), h.getOrDefault(e.get(1), 1) - 1);

                    break;
                case 3:
                    boolean flag = false;
                    for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
                        if (entry.getValue() == e.get(1)) {
                            o.add(1);
                            flag = true;
                            break;

                        }
                    }
                    if(flag == false){
                        o.add(0);
                    }






                    break;
                default:
                    break;
            }
        }
           return o;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);
        System.out.println(ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n");

        /*bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );
*/
        bufferedReader.close();
  //      bufferedWriter.close();
    }
}
