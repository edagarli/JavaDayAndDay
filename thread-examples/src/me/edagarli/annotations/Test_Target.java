package me.edagarli.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface Test_Target {
   public String doTestTarget();
}