//package me.edagarli.disruptor;
//
//import com.lmax.disruptor.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * User: edagarli
// * Email: lizhi@edagarli.com
// * Date: 16/5/21
// * Time: 15:08
// * Desc:
// */
//public class DisruptorTest {
//    public static void main(String[] args) throws InterruptedException {
//        //创建一个RingBuffer对象
//        RingBuffer<IntEvent> ringBuffer = new RingBuffer<IntEvent>(IntEvent.INT_ENEVT_FACTORY,
//                new SingleThreadedClaimStrategy(16), new SleepingWaitStrategy());
//        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
//        IntEventProducer[] producers = new IntEventProducer[1];
//        for(int i=0; i < producers.length; i++){
//            producers[i] = new IntEventProducer();
//        }
//        WorkerPool<IntEvent> crawler = new WorkerPool<IntEvent>(ringBuffer, sequenceBarrier, new IntEventExceptionHandler(), producers);
//        SequenceBarrier sb = ringBuffer.newBarrier(crawler.getWorkerSequences());
//        IntEventProcessor[] processors = new IntEventProcessor[1];
//        for (int i = 0; i<processors.length; i++){
//            processors[i] = new IntEventProcessor();
//        }
//        WorkerPool<IntEvent> applier = new WorkerPool<IntEvent>(ringBuffer, sb, new IntEventExceptionHandler(), processors);
//        List<Sequence> gatingSequences = new ArrayList<Sequence>();
//        for(Sequence s : crawler.getWorkerSequences()) {
//            gatingSequences.add(s);
//        }
//        for(Sequence s : applier.getWorkerSequences()) {
//            gatingSequences.add(s);
//        }
//        ringBuffer.setGatingSequences(gatingSequences.toArray(new Sequence[gatingSequences.size()]));
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 7, 10, TimeUnit.MINUTES,new LinkedBlockingQueue<Runnable>(5));
//        crawler.start(executor);
//        applier.start(executor);
//        while (true) {
//            Thread.sleep(1000);
//            long lastSeq = ringBuffer.next();
//            ringBuffer.publish(lastSeq);
//        }
//    }
//}
