package threads;


public class MyRunnable implements Runnable{
    @Override
    public void run() {
        go();
    }

    public void go(){
        doMore();
    }

    private void doMore() {
        System.out.println(Thread.currentThread().getName()+": top o' the stack");
        Thread.dumpStack();
    }
}
