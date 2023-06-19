package org.example.greedy;

public class MaximumScore {
    public int maximumScore(int[] nums, int k) {
        int result = nums[k];
        int i = k;
        int j = k;
        int curr = nums[k];
        int n = nums.length;
        while (i > 0 || j < n - 1){
            if(i == 0) {
                j += 1;
            }
            else if (j == n - 1) {
                i -= 1;
            }
            else if (nums[i - 1] < nums[j + 1]) {
                j += 1;
            }
            else {
                i -= 1;
            }
            curr = Math.min(curr, Math.min(nums[i], nums[j]));
            result = Math.max(result, (j - i + 1) * curr);
        }
        return result;
    }
}
