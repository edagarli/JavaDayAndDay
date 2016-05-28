package me.edagarli.thread;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Date: 16/5/28
 * Time: 15:57
 * Desc:
 */
public class DNSResolver implements Runnable {
    private String domain;
    private InetAddress inetAddr;

    public DNSResolver(String domain) {
        this.domain = domain;
    }

    public void run() {
        try {
            InetAddress addr = InetAddress.getByName(domain);
            set(addr);
        } catch (UnknownHostException e) {

        }
    }

    public synchronized void set(InetAddress inetAddr) {
        this.inetAddr = inetAddr;
    }
    public synchronized InetAddress get() {
        return inetAddr;
    }
}
