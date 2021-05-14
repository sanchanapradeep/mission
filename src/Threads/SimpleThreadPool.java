package Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
    public static void main(String[] args) {

     /*   ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++){
            Runnable worker = new Threads.WorkerThread(" "+i);
            executor.execute(worker);
        }
        executor.shutdown();
        while(executor.isTerminated()){

        }
        System.out.println("Finish all");
    */

    ExecutorService exe = Executors.newFixedThreadPool(5);
    for(int i=0;i<10;i++){
        WorkerThread workerThread = new WorkerThread(i+"");
        exe.execute(workerThread);
    }
    exe.shutdown();
    while(exe.isTerminated()){

    }
        System.out.println("Finish all");
    }

}
