/**
 * alibaba.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package me.edagarli.alg.array;

/**
 * @author edagarli.lz
 * @version 1.0.0
 * @ClassName SortArrayPingfang.java
 * @description 有序数组的平方
 *
 *
 * @createTime 2023年06月18日 20:13
 */
public class SortArrayPingfang {


    public static int[] sortedSquares(int[] nums) {

        int right = nums.length - 1;
        int left = 0;

        int[] result = new int[nums.length];

        int index = result.length - 1;

        while (left <= right) {

            if (nums[left] * nums[left] > nums[right] * nums[right]) {

                result[index--] = nums[left] * nums[left] ;
                ++left;

            } else {

                result[index--] = nums[right] * nums[right];
                --right;

            }

        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-4,-1,0,3,10};

        System.out.println(sortedSquares(nums));

    }

}
