/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        
        combination(candidates, target, candidates.length, new ArrayList<Integer>(), res);
        
        return res;
    }
    
    public void combination(int[] candidates, int target, int end, ArrayList<Integer> path,
        ArrayList<ArrayList<Integer>> res){
            
        if (target == 0) {
            res.add(path);
        }
        else if (target < 0) {
            return;
        }
        
        for (int i=0; i<end; i++) {
            if (candidates[i] <= target) {
                ArrayList<Integer> newpath = new ArrayList<Integer>();
                newpath.addAll(path);
                newpath.add(0,candidates[i]);
                combination(candidates, target-candidates[i], i+1, newpath, res);
            }
        }
    }
}
