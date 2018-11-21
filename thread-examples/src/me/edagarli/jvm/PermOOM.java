package me.edagarli.jvm;

/**
 * User: edagarli(卤肉)
 * Email: lizhi@edagarli.com
 * github: http://github.com/edagarli
 * Date: 16/12/28
 * Time: 23:44
 * Desc:
 */
public class PermOOM {

    public static void main(String args[]){
        try{
            for (int i = 0; i < 100000; i++) {
                // -XX:MaxPermSize = 5m
            }
        }catch (Exception e){
            
        }
    }
}
