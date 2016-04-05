package me.edagarli.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Date: 16/4/5
 * Time: 17:31
 * Desc:
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        new ThreadPoolTest().test();
    }

    private void test() {
        Toilet toilet = new Toilet();

        boolean allowed = true;
        for (int i=0; allowed; i++) {
            People p = new People(i+"", toilet);
            allowed = toilet.allowIn(p);
        }
    }

    private class Toilet {
        private volatile boolean cleaning = false;
        private volatile int volume=0;
        private final int CAPACITY = 100;
        private volatile int peopleIn = 0;
        private volatile int count = 0;
        private Cleaner cleaner;
        // 3 holes in his toilet.
        private ExecutorService holes = Executors.newFixedThreadPool(3);

        private Toilet() {
            this.cleaner = new Cleaner(this);
        }
        private synchronized boolean allowIn(Runnable people) {
            // If toilet is cleaning or 3 holes are taken, wait.
            while (this.cleaning == true || this.peopleIn >= 3 ) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Only serves 100 people one day.
            if (count > 100) {
                this.holes.shutdown();
                return false;
            } else {
                this.peopleIn(((People)people).name);
                holes.submit(people);
                return true;
            }
        }

        private synchronized void enEn(String name, int v) {
            this.volume += v;
            System.out.println("People["+name+"] put in ["+v+"]. Toilet volume increases to ["+volume+"]");

            // If the volume exceeds capacity, notify cleaner to clean.
            if (this.volume > this.CAPACITY) {
                this.notifyCleaner();
            }
        }

        private void notifyCleaner() {
            if (this.cleaning == false) {
                System.out.println("Toilet volume full with ["+volume+"]. Notify cleaner.");
                holes.submit(cleaner);
            }
        }

        private synchronized void peopleIn(String name) {
            System.out.println("People["+name+"] comes in.");
            this.peopleIn ++;
            this.count++;
        }

        private synchronized void peopleOut(String name) {
            System.out.println("People["+name+"] comes out.");
            this.peopleIn --;
            this.notifyAll();
        }
        public synchronized void cleaning() {
            this.cleaning = true;

        }
        public synchronized void cleaned() {
            this.cleaning = false;
            this.notifyAll();
        }
    }

    // One toilet cleaner.
    private class Cleaner implements Runnable {
        private Toilet toilet;
        private Cleaner(Toilet t) {
            this.toilet = t;
        }

        @Override
        public void run() {
            toilet.cleaning();
            System.out.println("Toilet Cleaning...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.toilet.volume = 0;
            System.out.println("Toilet Clean done.");
            toilet.cleaning = false;
            toilet.cleaned();
        }
    }

    private class People implements Runnable {
        private Toilet toilet;
        private String name;
        private People(String name, Toilet t) {
            this.toilet = t;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("People["+name+"] is en en en...");
            try {
                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            toilet.enEn(name, new Random().nextInt(11));
            toilet.peopleOut(name);
        }

    }

}