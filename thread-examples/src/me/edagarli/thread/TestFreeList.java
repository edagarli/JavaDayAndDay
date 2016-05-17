package me.edagarli.thread;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Date: 16/4/16
 * Time: 15:30
 * Desc: test LockFreeList, LockFreeVector, Vector, LinkedList
 */
public class TestFreeList {

     private static final int MAX_THREADS = 2000;

     private static final int TASK_COUNT = 4000;

     List list;

     public class AccessListThread implements Runnable {
         protected String name;
         java.util.Random random = new java.util.Random();
         public AccessListThread(){

         }
         public AccessListThread(String name){
             this.name = name;
         }

         @Override
         public void run() {
             try{
                for(int i=0; i<1000; i++)
                    handleList(random.nextInt(1000));
                 Thread.sleep(random.nextInt(100));
             } catch (InterruptedException e){
                 e.printStackTrace();
             }
         }
     }

    public class CounterPoolExecutor extends ThreadPoolExecutor{
        private AtomicInteger count =  new AtomicInteger(0);
        public long startTime = 0;
        public String funcName = "";

        public CounterPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            int  l = count.addAndGet(1);
            if(l == TASK_COUNT){
                System.out.println(funcName + " spend time:" + (System.currentTimeMillis() - startTime));
            }
        }
    }

    public Object handleList(int index){
        list.add(index);
        list.remove(index % list.size());
        return null;
    }

    public void initLinkedList(){
        List l = new ArrayList();
        for(int i=0; i<1000; i++){
            l.add(i);
        }
        list = Collections.synchronizedList(new LinkedList(l));
    }

    public void initVector(){
        List l = new ArrayList();
        for (int i=0; i<1000; i++)
            l.add(i);
        list = new Vector(l);
    }

    public void initFreeLockList(){
        List l = new ArrayList();
        for(int i=0; i<1000; i++)
            l.add(i);
//        list = new org.amino.ds.lockfree.LockFreeList(l);
    }

    public void initFreeLockVector(){
//        list = new org.amino.ds.lockfree.LockFreeVector();
        for(int i=0; i<1000; i++){
            list.add(i);
        }
    }

    public void testFreeLockList() throws InterruptedException {
        initFreeLockList();
        CounterPoolExecutor exe = new CounterPoolExecutor(MAX_THREADS,MAX_THREADS,0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        long startTime = System.currentTimeMillis();
        exe.startTime = startTime;
        exe.funcName = "testFreeLockList";
        Runnable t = new AccessListThread();
        for (int i=0; i<TASK_COUNT; i++){
            exe.submit(t);
        }
        Thread.sleep(10000);
    }

    public void testLinkedList() throws InterruptedException {
        initLinkedList();
        CounterPoolExecutor exe = new CounterPoolExecutor(MAX_THREADS,MAX_THREADS,0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        long startTime = System.currentTimeMillis();
        exe.startTime = startTime;
        exe.funcName = "testFreeLockList";
        Runnable t = new AccessListThread();
        for (int i=0; i<TASK_COUNT; i++){
            exe.submit(t);
        }
        Thread.sleep(10000);
    }

    public void testVector() throws InterruptedException {
        initVector();
        CounterPoolExecutor exe = new CounterPoolExecutor(MAX_THREADS,MAX_THREADS,0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        long startTime = System.currentTimeMillis();
        exe.startTime = startTime;
        exe.funcName = "testFreeLockList";
        Runnable t = new AccessListThread();
        for (int i=0; i<TASK_COUNT; i++){
            exe.submit(t);
        }
        Thread.sleep(10000);
    }

    public void testFreeLockVector() throws InterruptedException {
        initFreeLockVector();
        CounterPoolExecutor exe = new CounterPoolExecutor(MAX_THREADS,MAX_THREADS,0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        long startTime = System.currentTimeMillis();
        exe.startTime = startTime;
        exe.funcName = "testFreeLockList";
        Runnable t = new AccessListThread();
        for (int i=0; i<TASK_COUNT; i++){
            exe.submit(t);
        }
        Thread.sleep(10000);
    }

    public static void main(String args[]){
        try{
            TestFreeList list = new TestFreeList();
            list.testFreeLockList();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
