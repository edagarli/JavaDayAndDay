package me.edagarli.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Date: 16/5/17
 * Time: 11:56
 * Desc:
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors
            .newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
                        s.acquire();
                        Thread.sleep((long) (Math.random() * 6000));
                        s.release();
                        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        threadPool.shutdown();
    }
}