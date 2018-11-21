package me.edagarli.pro;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Date: 16/6/7
 * Time: 15:22
 * Desc:
 */
public class CodeTest {

    public static final String FORMAT_ZW_URL = "%sma/order/%s/%s/%s";

    public static void main(String args[]){
        String longUrl = String.format(FORMAT_ZW_URL, new Object[]{"http://blog.edagarli.com/", "99001331", "B2", "klfkafjaoidhqdihqiodhqj"});
        System.out.println(longUrl);
        String string = "wddksj";
        String[] parts = string.split("-");
        String part1 = parts[0];
//        String part2 = parts[1];
        System.out.println(part1 +"===>");
    }
}
