package me.edagarli.thread;

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
//                    handleList(random.nextInt(1000));
                 Thread.sleep(random.nextInt(100));
             } catch (InterruptedException e){
                 e.printStackTrace();
             }
         }
     }

     public static void main(String args[]){

     }

}
