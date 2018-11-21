package me.edagarli.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * github: http://github.com/edagarli
 * Date: 16/8/8
 * Time: 12:47
 * Desc:
 */
public class ForeachTest {
    public static void main(String[] args) {
        Map<String, List<Peopl>> map = new TreeMap<String, List<Peopl>>();
        test(map);
        List<Peopl> newClient = map.get("1");
        for(Peopl peopl : newClient){
            System.out.println("llllll"+peopl.getName());
        }
    }

    public static void test(Map<String, List<Peopl>> map){
        for(int i=0;i<9;i++){
            List<Peopl> client =  new ArrayList<Peopl>();
            map.put(String.valueOf(i), client);
        }
    }
}
