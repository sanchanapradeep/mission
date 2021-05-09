
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

class Result {

    /*
     * Complete the 'passwordCracker' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING loginAttempt
     */

    public static List<String> ans = new ArrayList<>();
    public static String passwordCracker(List<String> passwords, String loginAttempt) {
        // Write your code here
        if(loginAttempt.length() ==0){
            return ans.stream().collect(joining(" "));
        } else {
            for(String pwd:passwords) {
                if( loginAttempt.length() >= pwd.length() && loginAttempt.substring(0,pwd.length()).compareTo(pwd) == 0 ){
                    ans.add(pwd);
                    return passwordCracker(passwords, loginAttempt.substring(pwd.length()));
                }
            }
            return "WRONG PASSWORD";
        }
        //return ans.stream().collect(joining(" "));
    }

}

public class Passwords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> passwords = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList());

                String loginAttempt = bufferedReader.readLine();
                Result.ans.clear();
                Arrays.sort(passwords.toArray(),Collections.reverseOrder());
                String result = Result.passwordCracker(passwords, loginAttempt);

                System.out.println(result);
                //bufferedWriter.write(result);
                //bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
