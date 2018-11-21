package me.edagarli.alg;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: edagarli(卤肉)
 * Email: lizhi@edagarli.com
 * github: http://github.com/edagarli
 * Date: 2018/11/12
 * Time: 23:54
 * Desc:
 */
public class MoneyCalMain {

    public static void main(String[] args) throws Exception {
//        try {
//            //6个人
//            int cnt = 6;
//            //金额78块
//            BigDecimal all = new BigDecimal("78");
//            //团长金额
//            BigDecimal tuan = new BigDecimal("2200");
//            all = all.multiply(new BigDecimal(100));
//            for (int i = 0; i < 100; i++)
//            {
//                getRandom(cnt, all, tuan);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
       for (int i=0; i<10; i++) {
           System.out.println(getRandomList(5, 3));
       }
    }

    private static List<Float> getRandomList(int n, long seed) {
        Random random  = new Random(seed);
        List<Float> randomList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            randomList.add(random.nextFloat());
        }
        return randomList;
    }

    private static void getRandom(int cnt, BigDecimal all, BigDecimal tu) throws Exception {
        List<BigDecimal> list = new ArrayList<>();
        int res = 0;
        int min = all.intValue() / cnt ;
        for (int i = 0; i < cnt; i++) {
            int max = ((all.intValue() - res) / cnt * 2)  > tu.intValue() ? tu.intValue() : ((all.intValue() - res) / cnt * 2);
            int rand = 0;
            if (cnt - i == 1) {
                rand = all.intValue() - res;
            }
            else {
                rand = randInt(min, max);
//                rand = new Random().nextInt(max) + 1;
            }
            BigDecimal result = new BigDecimal(rand).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_DOWN);
            list.add(result);
            res += rand;
        }
        System.out.println(list);
    }

    private static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum;
//        if(max <= min) {
//            randomNum = rand.nextInt((min - max) + 1) + max;
//        } else {
            randomNum = rand.nextInt((max - min) + 1) + min;
//        }
        return randomNum;
    }
}
