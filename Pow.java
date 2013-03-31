// Implement pow(x, n).

public class Solution {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        
        double res = 1;
        double power = x;
        
        int N = Math.abs(n);
        
        while(N>0) {
            if (N%2 == 1) {
                res *= power;
            }
            power *= power;
            N /= 2;
        }
        
        return (n>0)? res : 1/res;
    }
}