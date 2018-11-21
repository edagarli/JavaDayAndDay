//package me.edagarli.qlexpress;
//
//import com.ql.util.express.DefaultContext;
//import com.ql.util.express.ExpressRunner;
//
///**
// * User: edagarli(卤肉)
// * Email: lizhi@edagarli.com
// * github: http://github.com/edagarli
// * Date: 2017/7/20
// * Time: 20:29
// * Desc:
// */
//public class ExpressTest {
//
//    public static void main (String args[]) {
//        try {
//            ExpressRunner runner = new ExpressRunner();
//            DefaultContext<String, Object> context = new DefaultContext<String, Object>();
//            context.put("a",1);
//            context.put("b",2);
//            context.put("c",3);
//            String express = "a+b*c";
//            Object r = runner.execute(express, context, null, true, false);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
