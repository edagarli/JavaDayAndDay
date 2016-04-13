package me.edagarli.heap;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Date: 16/4/14
 * Time: 00:05
 * Desc:
 */
public class HeapAlloc {
    public static void main(String[] args){
        System.out.println("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 /1024+" M");
        System.out.println("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024 /1024+" M");
        System.out.println("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 /1024+" M");

        byte[] b = new byte[1*1024*1024];
        System.out.println("分配了1M空间给数组");

        System.out.println("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 /1024+" M");
        System.out.println("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024 /1024+" M");
        System.out.println("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 /1024+" M");

        b = new byte[4*1024*1024];
        System.out.println("分配了4M空间给数组");

        System.out.println("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 /1024+" M");
        System.out.println("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024 /1024+" M");
        System.out.println("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 /1024+" M");
    }
}
