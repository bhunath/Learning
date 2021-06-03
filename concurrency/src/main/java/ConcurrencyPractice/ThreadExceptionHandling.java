package ConcurrencyPractice;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ThreadExceptionHandling {

    final public static void main(String[] args) throws InterruptedException {
        Callable<String> call = ()->{return "Hello";};
        Thread th1 = new Thread(call);
        Thread exceptionThrowingThread = new Thread(new ExceptionTask());
        exceptionThrowingThread.setName("ExceptionThread");

        exceptionThrowingThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " : Exception Caught !!");
            }
        });
        exceptionThrowingThread.setDaemon(true);
        exceptionThrowingThread.start();
        System.out.println("Exiting ConcurrencyPractice.Main Thread!!");
    }

    public static class ExceptionTask implements Runnable{

        @Override
        public void run() {
            throw new RuntimeException("Intentional Exception");
        }
    }
}
