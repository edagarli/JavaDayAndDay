package me.edagarli.thread;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Date: 16/5/28
 * Time: 15:41
 * Desc:
 */
public class DNSTest {
    private static final String host = "localhost";
    public static void main(String args[]){
        DNSResolver dnsRes = new DNSResolver(host);
        Thread t = new Thread(dnsRes);
        t.start();
        try {
            t.join(1000);
            InetAddress inetAddr = dnsRes.get();
            System.out.println(inetAddr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
