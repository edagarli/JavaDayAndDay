package me.edagarli;

import java.util.*;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Desc:
 */

public class Main {

    public static void main(String[] args) {

        List<Date> list = new ArrayList<Date>();
        list.add(new Date(1459844531000L));
        list.add(new Date(1459844511000L));
        Collections.sort(list , new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });

        for(Date d : list){
            System.out.println(d);
        }
    }
}
