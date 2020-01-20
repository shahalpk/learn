import java.io.*;

class MaximumSubarray {
    public static void main(String args[]) throws IOException {
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4,2};
        Solution sol = new Solution();
        System.out.println(sol.maxSubArray(a));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int curSum, maxSum;

        curSum = nums[0];
        maxSum = nums[0];

        for (int i=1; i<nums.length; i++){
            int n = nums[i];
            if (n > (curSum + n)){
                curSum = n;
            } else {
                curSum = curSum + n;
            }
            if (curSum > maxSum){
                maxSum = curSum;
            }
        }

        return maxSum;
    }
}