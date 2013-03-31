/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/


public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <=1) return 0;
        int[] history = forward(prices);
        int[] future = backward(prices);
        
        int max = Integer.MIN_VALUE;
        
        for (int i=0; i<prices.length; i++) {
            max = Math.max(max, history[i]+future[i]);
        }
        return max;
    }
    
    public int[] forward(int[] prices) {
        if (prices.length <= 1) return null;
        
        int valley = prices[0];
        int[] historyProfit = new int[prices.length];
        
        for (int i=0;i<prices.length;i++) {
            historyProfit[i] = 0;
        }
        
        for (int i=0;i<prices.length;i++) {
            valley = Math.min(valley, prices[i]);
            
            if (i >= 1) {
                historyProfit[i] = Math.max(historyProfit[i-1], prices[i]-valley);
            }
        }
        return historyProfit;
    }
    
    public int[] backward(int[] prices) {
        if (prices.length <=1) return null;
        int peak = prices[prices.length-1];
        int[] future = new int[prices.length];
        
        for (int i=0;i<prices.length;i++) {
            future[i] = 0;
        }
        
        for (int i=prices.length-1; i>=0; i--) {
            peak = Math.max(peak,prices[i]);
            if (i<prices.length-1) {
                future[i] = Math.max(future[i+1], peak-prices[i]);
            }
        }
        return future;
    }
}
