package me.edagarli.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Date: 16/5/17
 * Time: 20:30
 * Desc:
 */
public class AtomicTest {
    private final static AtomicInteger threadNumber = new AtomicInteger(1);

    public static void main(String[] args) {
        for(int i = 0; i < 10000; i++){
            new Thread(new Runnable() {
                public void run() {
                    if(threadNumber.get() > 1){
                        System.out.println(Thread.currentThread().getName()+" value="+threadNumber.get()+" return null");
                    }else{
                        threadNumber.incrementAndGet();
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+" value="+threadNumber.get()+" ok!");
                        threadNumber.decrementAndGet();
                    }
                    System.out.println("threadNumber::"+threadNumber.get());
                }
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
