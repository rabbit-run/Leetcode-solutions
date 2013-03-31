/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        if(num.length < 4) return new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for (int i=0; i<num.length;i++) {
            for (int j=i+1; j<num.length;j++) {
                for (int k=j+1, l=num.length-1;k<l;) {
                    int sum = num[i] + num[j] + num[k] + num[l];
                    if (target == sum) {
                        ArrayList<Integer> arr = new ArrayList<Integer>();
                        arr.add(num[i]);
                        arr.add(num[j]);
                        arr.add(num[k]);
                        arr.add(num[l]);
                        res.add(arr);
                        while(k+1<l && num[k] == num[k+1]) {
                            k++;
                        }
                        k++;
                        while(l-1>k && num[l] == num[l-1]) {
                            l--;
                        }
                        l--;
                    }
                    else if(sum < target) {
                        while(k+1<l && num[k] == num[k+1]) {
                            k++;
                        }
                        k++;
                    }
                    else {
                        while(l-1>k && num[l] == num[l-1]) {
                            l--;
                        }
                        l--;
                    }
                    
                }
                while(j+1<num.length && num[j] == num[j+1]) {
                    j++;
                }
            }
            while(i+1<num.length && num[i] == num[i+1]) {
                i++;
            }
        }
        return res;
    }
}
