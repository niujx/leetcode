package com.rock.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoNumSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int test = target - nums[i];
            if (maps.containsKey(test)) {
                return new int[]{maps.get(test), i};
            }
            maps.put(nums[i], i);
        }

        throw new RuntimeException("not found");
    }
}
