package org.example.mergeSort;

public class CountOfRangeSum {
    class Solution {
        int lower;
        int upper;
        int result;
        long [] preSum;
        public int countRangeSum(int[] nums, int lower, int upper) {
            preSum = new long [nums.length + 1];
            this.lower = lower;
            this.upper = upper;
            result = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            mergeSort(0, nums.length);
            return result;
        }
        public void mergeSort(int start, int end) {
            if(start >= end) {
                return;
            }
            int mid = start + (end - start) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            int i = mid + 1;
            int j = mid + 1;
            long [] num = preSum;
            for (int k = start; k <= mid; k++) {
                while (i <= end && preSum[i] - preSum[k] < lower) {
                    i += 1;
                }
                while (j <= end && preSum[j] - preSum[k] <= upper) {
                    j += 1;
                }
                result += j - i;
            }
            merge(start, end, mid);
        }
        public void merge(int start, int end, int mid) {
            long [] temp = new long [end - start + 1];
            for (int i = start; i <= end; i++) {
                temp[i - start] = preSum[i];
            }
            int i = start;
            int j = mid + 1;
            int index = start;
            while (i <= mid && j <= end) {
                if(temp[i - start] < temp[j - start]) {
                    preSum[index] = temp[i - start];
                    i += 1;
                    index += 1;
                }
                else {
                    preSum[index] = temp[j - start];
                    j += 1;
                    index += 1;
                }
            }
            while (i <= mid) {
                preSum[index] = temp[i - start];
                i += 1;
                index += 1;
            }
            while (j <= end) {
                preSum[index] = temp[j - start];
                j += 1;
                index += 1;
            }
        }
    }
}
