package me.edagarli.project;


import org.apache.commons.lang3.StringUtils;

/**
 * User: edagarli(卤肉)
 * Email: lizhi@edagarli.com
 * github: http://github.com/edagarli
 * Date: 16/11/10
 * Time: 15:15
 * Desc:
 */
public class ETagQUes {

    public static void main(String args[]){
        StringBuffer eTag = new StringBuffer(StringUtils.EMPTY);
        sss(eTag);
        System.out.println(eTag);
        System.out.println(eTag.toString());
        System.out.println(eTag.toString().hashCode());
        System.out.println(String.valueOf(eTag.toString().hashCode()));
    }

    public static String sss(StringBuffer eTag){
        eTag.append("Sdsf");
        return null;
    }
}
