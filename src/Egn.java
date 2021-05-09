import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


public class Egn {


    static HashMap<String, Long> freqMap = new HashMap<>();
    private static String[] readUrls(String filePath) throws  IOException {

        String[] s = null;
        try{
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            s = new String[lines.size()];
            for(int i=0;i<lines.size();i++){
                s[i] = lines.get(i);
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return s;

    }

    private  static void countMultiThreaded(String filePath) throws IOException{
        String[] urls = readUrls(filePath);

        //TODO:implement this using multiple threads
        ExecutorService exe = Executors.newFixedThreadPool(10);
        for(int i=0;i<urls.length;i++){
            WorkerThread2 workerThread = new WorkerThread2(urls[i]);
            exe.execute(workerThread);
        }
        exe.shutdown();
        while(exe.isTerminated()){

        }
        //System.out.println("Finish all");
    }



    public static void main(String[] args)  throws IOException{
        String filePath = args[0];

        countMultiThreaded(filePath);
        System.out.println(freqMap.toString());

    }
    public static class WorkerThread2 implements Runnable{

        private String url;
        public WorkerThread2(String s){
            this.url =s;
        }
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName()+ " Start download = "+ url);
            try{
                String content = readArticle(url);
                textWordFreq(content);
            } catch (Exception e){
                System.out.println("EXCEPTION :"+e.getMessage());
                e.getStackTrace();

            }
            System.out.println(Thread.currentThread().getName()+ " End download = "+ url);


        }
        private String readArticle(String articleUrl) throws Exception {
            URL url = new URL(articleUrl);
            HttpURLConnection c = (HttpURLConnection)url.openConnection();
            StringBuilder sb = new StringBuilder();
            if(c.getResponseCode() == HttpURLConnection.HTTP_OK){
                try(BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()))){
                    String s = null;
                    while((s= br.readLine())!= null){
                        sb.append(s);
                    }
                }
            }
            return sb.toString();
        }
        public static void textWordFreq(String text) {
            Arrays.asList(text.split("[\\s.]")).forEach(s -> {
                freqMap.merge(s, 1L, Long::sum);
            });
        }

        @Override
        public String toString(){
            return this.url;
        }
    }




}
