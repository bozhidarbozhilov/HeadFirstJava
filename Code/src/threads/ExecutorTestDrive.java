package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTestDrive {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(()-> System.out.println("Top o' stack"));
        System.out.println("Back in main");
        executor.shutdown();
    }
}
