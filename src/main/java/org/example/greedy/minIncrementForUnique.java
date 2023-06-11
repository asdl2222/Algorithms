package org.example.greedy;
//You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
//
//Return the minimum number of moves to make every value in nums unique.
//
//The test cases are generated so that the answer fits in a 32-bit integer.
public class minIncrementForUnique {
    public int minIncrementForUnique(int [] nums) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int [] arr = new int [max + n];
        int taken = 0;
        int moves = 0;
        for (int num : nums) {
            arr[num] += 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                taken += arr[i] - 1;
                moves -= (arr[i] - 1) * i;
            }
            else if (taken > 0 && arr[i] == 0) {
                taken -= 1;
                moves += i;
            }
        }
        return moves;
    }

}
