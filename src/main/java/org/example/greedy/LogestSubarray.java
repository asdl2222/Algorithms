package org.example.greedy;

import java.util.Deque;
import java.util.LinkedList;

public class LogestSubarray {
//    Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
public int longestSubarray(int[] nums, int limit) {
    int result = Integer.MIN_VALUE;
    Deque<Integer> max = new LinkedList<>();
    Deque<Integer> min = new LinkedList<>();
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
        while(max.size() > 0  && nums[i] >= nums[max.peekLast()]) {
            max.removeLast();
        }
        max.addLast(i);
        while (min.size() > 0 && nums[i] <= nums[min.peekLast()]) {
            min.removeLast();
        }
        min.addLast(i);
        int firstMax = max.peekFirst();
        int firstMin = min.peekFirst();
        if(nums[firstMax] - nums[firstMin] <= limit) {
            result = Math.max(result, i - j + 1);
        }
        else {
            j += 1;
            while (max.size() > 0 && j > max.peekFirst()) {
                max.removeFirst();
            }
            while (min.size() > 0 && j > min.peekFirst()) {
                min.removeFirst();
            }
        }
    }
    return result;
}
}
