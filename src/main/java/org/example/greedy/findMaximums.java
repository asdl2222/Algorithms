package org.example.greedy;

import java.util.Arrays;
import java.util.Stack;

public class findMaximums
{
    public int[] findMaximums(int[] nums) {
        int [] l = new int [nums.length];
        int [] r = new int [nums.length];
        l[0] = -1;
        r[nums.length - 1] = nums.length;
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        for (int i = 0; i < nums.length; i++) {
            while (stack.peek() != -1 && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            l[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        stack.push(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            while (stack.peek() != nums.length && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            r[i] = stack.peek();
            stack.push(i);
        }
        int [] temp = new int [nums.length];
        Arrays.fill(temp, -1);
        for (int i = 0; i < nums.length; i++) {
            int index = r[i] - l[i] - 1;
            temp[index - 1] = Math.max(temp[index - 1], nums[i]);
        }
        int last = Integer.MIN_VALUE;
        for (int i = temp.length - 1; i>= 0; i--) {
            last = Math.max(last, temp[i]);
            temp[i] = last;
        }
        return temp;
    }
}
