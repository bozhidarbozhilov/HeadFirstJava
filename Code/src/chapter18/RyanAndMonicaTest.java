package chapter18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RyanAndMonicaTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        RyanAndMonicaJob ryan = new RyanAndMonicaJob("Ryan", account, 50);
        RyanAndMonicaJob monica = new RyanAndMonicaJob("Monica", account, 100);
        ExecutorService executor = Executors.newFixedThreadPool(2);


        //potential race condition
        executor.execute(ryan);
        executor.execute(monica);
        executor.shutdown();

    }

    private static class BankAccount {
        private AtomicInteger balance = new AtomicInteger(100);
        public int getBalance() {
            return balance.get();
        }

        public void spend(int amountToSpent, String name) {
            int initialBalance = balance.get();
            if (initialBalance >= amountToSpent) {
                boolean success = balance.compareAndSet(initialBalance, initialBalance-amountToSpent);
                if (!success) {
                    System.out.println("Sorry " + name + ", you haven't spent the money.");
                }
                if (balance.get() < 0) {
                    System.out.println("Overdrawn.");
                }
            }else {
                System.out.println("Sorry not enough for " + name);
            }
        }
    }

    private static class RyanAndMonicaJob implements Runnable {
        private final String name;
        private final BankAccount account;
        private final int amountToSpent;
        public RyanAndMonicaJob(String name, BankAccount account, int amountToSpent) {
            this.name = name;
            this.account = account;
            this.amountToSpent = amountToSpent;
        }

        @Override
        public void run() {
            goShopping(amountToSpent);
        }

        private void goShopping(int amountToSpent) {
            System.out.println(name + " is about to spend.");
            account.spend(amountToSpent, name);
            System.out.println(name + " finishes spending");
        }
    }
}
