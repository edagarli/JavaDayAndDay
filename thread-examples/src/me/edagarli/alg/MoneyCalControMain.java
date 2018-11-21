package me.edagarli.alg;

import com.alibaba.common.convert.Convert;

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
public class MoneyCalControMain {

    public static void main(String[] args) throws Exception {
       for (int i=0; i<20; i++) {
           System.out.println(createBonusList(7800, 6, 2200));
       }
    }



    /**
     * 返回min~max区间内随机数，含min和max
     * @param min
     * @param max
     * @return
     */
    private static int getRandomVal(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * 随机分配第n个红包
     * @param totalBonus 总红包量
     * @param totalNum 总份数
     * @param sendedBonus 已发送红包量
     * @param sendedNum 已发送份数
     * @param rdMin 随机下限
     * @param rdMax 随机上限
     * @return
     */
    private static Integer randomBonusWithSpecifyBound(Integer totalBonus, Integer totalNum, Integer sendedBonus,
                                                       Integer sendedNum, Integer rdMin, Integer rdMax) {
        Integer boundMin = Math.max((totalBonus - sendedBonus - (totalNum - sendedNum - 1) * rdMax), rdMin);
        Integer boundMax = Math.min((totalBonus - sendedBonus - (totalNum - sendedNum - 1) * rdMin), rdMax);
        return getRandomVal(boundMin, boundMax);
    }

    /**
     * 生成红包一次分配结果
     * @param totalBonus 总红包量
     * @param totalNum 总份数
     * @return
     */
    public static List<Double> createBonusList(Integer totalBonus, Integer totalNum, Integer authorNum) {
        Integer sendedBonus = 0;
        Integer sendedNum = 0;
        Integer rdMin = (int) (totalBonus / totalNum * 0.5);
        Integer rdMax = (int) (totalBonus / totalNum * 2);
        rdMax = Math.min(rdMax, authorNum);
        List<Double> bonusList = new ArrayList<>();
        while (sendedNum < totalNum) {
            Integer bonus = randomBonusWithSpecifyBound(totalBonus, totalNum, sendedBonus, sendedNum, rdMin, rdMax);
            bonusList.add(Convert.asDouble(bonus) / 100);
            sendedNum++;
            sendedBonus += bonus;
        }
        return bonusList;
    }
}
