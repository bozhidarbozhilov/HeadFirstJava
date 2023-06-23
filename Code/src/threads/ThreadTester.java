package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTester {
    public static void main(String[] args){
        Runnable threadJob = new MyRunnable();
        //Use Thread directly
//        Thread myThread = new Thread(threadJob);
//        myThread.start();
        //Use ExecutorService
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(threadJob);

        System.out.println(Thread.currentThread().getName()+": back in main");
        Thread.dumpStack();
        executor.shutdown();
    }
}
