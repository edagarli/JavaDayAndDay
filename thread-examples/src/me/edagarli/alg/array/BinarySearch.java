/**
 * alibaba.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package me.edagarli.alg.array;

/**
 * @author edagarli.lz
 * @version 1.0.0
 * @ClassName BinarySearch.java
 * @description
 *
 *
 *二分搜索
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 * #
 *
 * @createTime 2023年06月17日 17:55
 */
public class BinarySearch {

    public int search(int[] nums, int target) {

        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return  -1;
    }

}
