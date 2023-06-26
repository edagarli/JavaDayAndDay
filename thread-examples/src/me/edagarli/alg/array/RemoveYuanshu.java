/**
 * alibaba.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package me.edagarli.alg.array;

/**
 * @author edagarli.lz
 * @version 1.0.0
 * @ClassName RemoveYuanshu.java
 * @description
 *
 * 双指针法（快慢指针法）
 *
 *示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 *
 * @createTime 2023年06月18日 19:16
 */
public class RemoveYuanshu {

    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex =0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

}
