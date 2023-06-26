/**
 * alibaba.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package me.edagarli.alg.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author edagarli.lz
 * @version 1.0.0
 * @ClassName LengthMinSubArray.java
 * @description
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 一些录友会疑惑为什么时间复杂度是O(n)。
 *
 * 不要以为for里放一个while就以为是O(n^2)啊， 主要是看每一个元素被操作的次数，每个元素在滑动窗后进来操作一次，出去操作一次，每个元素都是被操作两次，所以时间复杂度是 2 × n 也就是O(n)。
 *
 * 复杂度分析
 *
 * 时间复杂度：
 * �
 * (
 * �
 * )
 * O(n)，其中
 * �
 * n 是数组
 * fruits
 * fruits 的长度。
 *
 * 空间复杂度：
 * �
 * (
 * 1
 * )
 * O(1)。哈希表中最多会有三个键值对，可以看成使用了常数级别的空间。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/fruit-into-baskets/solution/shui-guo-cheng-lan-by-leetcode-solution-1uyu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @createTime 2023年06月20日 21:53
 */
public class LengthMinSubArray {


    // 滑动窗口
    public int minSubArrayLen(int s, int[] nums) {


         int left = 0;
         int sum = 0;
         int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= s) {


                result = Math.min(result, right - left + 1);

                sum -= nums[left++];


            }

        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static int totalFruit(int[] fruits) {

        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; right++) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }


    public static void main(String[] args) {

        //int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        //System.out.println(totalFruit(fruits));

    }
}
