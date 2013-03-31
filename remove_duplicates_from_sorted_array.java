/*
Given a sorted array, remove the duplicates in place such that
each element appear only once and return the new length.
*/



public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        if (A.length == 1) return 1;
        
        int slow_runner = 1;
        int fast_runner = 1;
        int pre = A[0];
        
        while (fast_runner < A.length) {
            if (A[fast_runner] != pre) {
                pre = A[fast_runner];
                if(slow_runner != fast_runner) {
                    A[slow_runner] = A[fast_runner];
                }
                slow_runner++;
                fast_runner++;
            }
            else {
                fast_runner++;
            }
        }
        
        return slow_runner;
    }
}