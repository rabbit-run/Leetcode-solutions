/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/


public class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> dic = new HashMap<Integer, Integer>();
        return go(n, dic);
    }
    
    public int go(int n, HashMap<Integer, Integer> dic) {
        if(dic.containsKey(n)) {
            return dic.get(n);
        }
        
        int tmp = 0;
        
        if(n == 0) {
            return 1;
        } 
        else if (n<0) {
            return 0;
        }
        else {
            tmp = go(n-1, dic) + go(n-2, dic);
        }
        dic.put(n, tmp);
        return tmp;
    }
}
