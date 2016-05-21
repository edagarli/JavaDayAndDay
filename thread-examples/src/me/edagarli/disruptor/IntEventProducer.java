package me.edagarli.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Date: 16/5/21
 * Time: 15:05
 * Desc:
 */
public class IntEventProducer implements WorkHandler<IntEvent> {
    private int seq = 0;

    @Override
    public void onEvent(IntEvent intEvent) throws Exception {
        System.out.println("produced " + seq);
        intEvent.setValue(++seq);
    }
}
