/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for (int i=0;i<num.length-2;i++) {
            for (int j=i+1,k=num.length-1;j<k;) {
                int sum = num[i] + num[j] + num[k];
  
                if (sum == 0) {
                    res.add(new ArrayList<Integer>(
                    Arrays.asList(num[i],num[j],num[k])));
                    while (j+1 < k && num[j+1] == num[j]) {
                        j++;
                    }
                    j++;
                     
                    while (k-1 > j && num[k-1] == num[k]) {
                        k--;
                    }
                    k--;
                }
                else if (sum > 0) {
                    k--;
                }
                else if (sum < 0) {
                    j++;
                }
            }
            while (i+1<num.length && num[i]==num[i+1]){
                i++;
            }
        }
        return res;  
    }
}
