package me.edagarli.Util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Date: 16/6/29
 * Time: 16:04
 * Desc:
 */
public class RandomUtil {

    /** 产生一个随机的字符串*/
    public static String RandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
//            int num = random.nextInt(62);
            int num = ThreadLocalRandom.current().nextInt(62);
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }

    public static String RandomTestString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(62);
//            int num = ThreadLocalRandom.current().nextInt(62);
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }

    public static String random(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append( (char)(ThreadLocalRandom.current().nextInt(33, 128)));
        }
        return builder.toString();
    }

    public static void main(String args[]){
//        System.out.println( RandomUtil.RandomString(6));
//        System.out.println( RandomUtil.random(6));

        long begin = System.nanoTime();
        System.out.println("current:"+ begin);
        for(int i=0 ; i< 100000; i++){
            RandomUtil.RandomString(6);
        }
        long end = System.nanoTime();
        System.out.println("end:"+ end);
        System.out.println("count:"+ (end-begin));

        long begin1 = System.nanoTime();
        System.out.println("current:"+ begin1);
        for(int i=0 ; i< 100000; i++){
            RandomUtil.RandomTestString(6);
        }
        long end1 = System.nanoTime();
        System.out.println("end:"+ end1);
        System.out.println("count:"+ (end1-begin1));

        final int MAX = 100000;
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        long start = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            threadLocalRandom.nextDouble();
        }
        long endww = System.nanoTime() - start;
        System.out.println("use time1 : " + endww);

        long start2 = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            Math.random();
        }
        long end2 = System.nanoTime() - start2;
        System.out.println("use time2 : " + end2);

    }
}
