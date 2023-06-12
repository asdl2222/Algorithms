package org.example.greedy;
//You are given an integer array nums. The value of this array is defined as the sum of |nums[i] - nums[i + 1]| for all 0 <= i < nums.length - 1.
//
//You are allowed to select any subarray of the given array and reverse it. You can perform this operation only once.
//
//Find maximum possible value of the final array.
public class ReverseSubarrayToMaximizeArrayValue {
    public int maxValueAfterReverse(int[] nums) {
        // 4,9 9,24 24,2 2,1 -> 1,2 2,24 24,9 9,4
        // 5 - 2 3 - 2 2 -5 2- 3
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            total += Math.abs(a - b);
            result = Math.max(result, Math.abs(nums[0] - b) - Math.abs(a - b));
            result = Math.max(result, Math.abs(nums[n - 1] - a) - Math.abs(a - b));
            min = Math.min(min, Math.max(a, b));
            max = Math.max(max, Math.min(a, b));
        }
        return total + Math.max(result, (max - min) * 2);
    }
}
