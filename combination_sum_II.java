/*

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        
        combination(candidates, target, candidates.length, new ArrayList<Integer>(), res);
        
        return res;
    }
    
    public void combination(int[] candidates, int target, int end, ArrayList<Integer> path,
        ArrayList<ArrayList<Integer>> res){
            
        if (target == 0) {
            if (!res.contains(path)){
                res.add(path);
            }
        }
        else if (target < 0) {
            return;
        }
        
        for (int i=0; i<end; i++) {
            if (candidates[i] <= target) {
                ArrayList<Integer> newpath = new ArrayList<Integer>();
                newpath.addAll(path);
                newpath.add(0,candidates[i]);
                combination(candidates, target-candidates[i], i, newpath, res);
            }
        }
    }
}
