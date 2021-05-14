package Threads;

public class Thread1 implements Runnable {

    @Override
    public void run(){
        String url = "";
        System.out.println(Thread.currentThread().getName()+ " Start download = "+ url);
        try{
            wait(1000);
            //String content = readArticle(url);
            //textWordFreq(content);
        } catch (Exception e){
            System.out.println("EXCEPTION :"+e.getMessage());
            e.getStackTrace();

        }
        System.out.println(Thread.currentThread().getName()+ " End download = "+ url);

    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+ " Start download = ");
        Thread1 runnable = new Thread1();
        Thread t1 = new Thread(runnable);
        System.out.println(" Starting Thread ");
        t1.start();

    }
}
