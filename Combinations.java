/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/


public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if(k == 0) return new ArrayList();
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        cnk(k,n,new ArrayList<Integer>(), res);
        
        return res;
    }
    
    public void cnk(int k, int end, ArrayList<Integer> combines, ArrayList<ArrayList<Integer>> res) {
        if (end < k) {
            return;
        }
        else if (k == 0) {
            Collections.sort(combines);
            res.add(combines);
            return;
        }
        else if (end == k) {
            for (int i=1; i<=end; i++) {
                combines.add(i);
            }
            Collections.sort(combines);
            res.add(combines);
            return;
        }
        
        for (int i=1; i<=end; i++) {
            ArrayList<Integer> newCombines = new ArrayList<Integer>();
            newCombines.addAll(combines);
            newCombines.add(i);
            cnk(k-1, i-1, newCombines, res);
        }
    }
}

