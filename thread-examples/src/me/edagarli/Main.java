package me.edagarli;

import com.alibaba.common.lang.ExceptionUtil;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Desc:
 */

public class Main {

    public static void main(String[] args) {

//        List<Date> list = new ArrayList<Date>();
//        list.add(new Date(1459844531000L));
//        list.add(new Date(1459844511000L));
//        Collections.sort(list , new Comparator<Date>() {
//            @Override
//            public int compare(Date o1, Date o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        for(Date d : list){
//            System.out.println(d);
//        }

        StringBuilder builder = new StringBuilder();
        try {
            System.out.println(Thread.currentThread());
            System.out.println(1 / 0);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e);
            System.out.println(e.toString());
            System.out.println("--------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------");
            System.out.println(e.getStackTrace());
            System.out.println("--------------------");
            System.out.println(e.getCause());
            System.out.println("--------------------");
            String fullStackTrace = ExceptionUtil.getStackTrace(e);
            System.out.println(fullStackTrace);
//            System.out.println(e.fillInStackTrace());
//            StackTraceElement[] st = Thread.currentThread().getStackTrace();
//            for (StackTraceElement item : st) {
//                builder.append(item.getFileName()).append(":").append(item.getLineNumber());
//                builder.append(item.getClassName()).append(":").append(item.getMethodName()).append(System.lineSeparator());
//            }
//            System.out.println(exceptionToStr(e));
            StringBuffer sbf = new StringBuffer(e.getClass().getName()+": "+e.getMessage()+"\n");
            System.out.println(Thread.currentThread());
            StackTraceElement[] ste = Thread.currentThread().getStackTrace();
            for(int i=0;i<ste.length;i++){
                sbf.append("\t"+ste[i].getClassName()+"."+ste[i].getMethodName()+"("+ste[i].getFileName()+":"+ste[i].getLineNumber()+")\t\n");
            }
            System.out.println(sbf.toString());
        }
    }

    /**
     * 返回Exception 中 printStackTrace中的一些信息
     * @param e
     * @return String类型错误信息，其中包括ClassName,FileName,MethodName,LineNumber
     */
    public static String exceptionToStr(Exception e){
        StringBuffer sbf = new StringBuffer(e.getClass().getName()+": "+e.getMessage()+"\n");
        StackTraceElement[] ste = e.getStackTrace();
        for(int i=0;i<ste.length;i++){
            sbf.append("\t"+ste[i].getClassName()+"."+ste[i].getMethodName()+"("+ste[i].getFileName()+":"+ste[i].getLineNumber()+")\t\n");
        }
        return sbf.toString();
    }
}
