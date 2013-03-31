/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    */

    public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int len = num.length;
        int closest = num[0] + num[1] + num[2];
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        for (int i=0;i<len-2;i++) {
            for (int j=i+1, k=len-1; j<k;) {
                sum = num[i]+num[j]+num[k];
                if (sum == target) {
                    return sum;
                }
                else if (sum<target) {
                    j++;
                }
                else {
                    k--;
                }
                if (Math.abs(sum-target) < min) {
                    min = Math.abs(sum-target);
                    closest = sum;
                }
            }
        }
        return closest;
    }
}
