package me.edagarli.annotations;

public class TestAnnotations {
   public static void main(String arg[]) {
      new TestAnnotations().doTestTargets();
   }
   // 在方法上使用注解,OK.
   // 中间也可以不换行,换2行之类,Java忽略多余的换行
   @Test_Target(doTestTarget="Hello World !")
   public void doTestTargets() {
//      System.out.printf("Testing Target annotation");
   }
}
