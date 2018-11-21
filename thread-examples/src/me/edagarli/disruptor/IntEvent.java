//package me.edagarli.disruptor;
//
//import com.lmax.disruptor.EventFactory;
//
///**
// * User: edagarli
// * Email: lizhi@edagarli.com
// * Date: 16/5/21
// * Time: 14:56
// * Desc:  RingBuffer中存储的单元
// */
//public class IntEvent {
//    private int value = -1;
//
//    public int getValue() {
//        return value;
//    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return String.valueOf(value);
//    }
//
//    public static EventFactory<IntEvent> INT_ENEVT_FACTORY = new EventFactory<IntEvent>() {
//        public IntEvent newInstance() {
//            return new IntEvent();
//        }
//    };
//}
