package org.example.greedy;

import java.util.Arrays;

//You are given an integer array nums and an integer k.
//
//For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.
//
//The score of nums is the difference between the maximum and minimum elements in nums.
//
//Return the minimum score of nums after changing the values at each index.
public class smallestRangeII {
    public int smallestRangeII(int [] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(nums[n - 1] - k, nums[i] + k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            result = Math.min(result, max - min);
        }
        return result;
    }
}
