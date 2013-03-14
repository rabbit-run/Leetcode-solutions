/* 
Given two sorted integer arrays A and B, merge B into A as one sorted array.
*/

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (n==0) return;
        if (m==0) {
            for(int i=0; i<n; i++) {
                A[i] = B[i];
            }
            return;
        }
        
        int cursor = m+n-1;
        int a_cursor = m-1;
        int b_cursor = n-1;
        
        while (a_cursor>=0 && b_cursor>=0) {
            if(A[a_cursor] < B[b_cursor]) {
                A[cursor] = B[b_cursor];
                b_cursor--;
            }
            else {
                int tmp = A[cursor];
                A[cursor] = A[a_cursor];
                A[a_cursor] = tmp;
                a_cursor--;
            }
            cursor--;
        }
        
        if (b_cursor >= 0) {
            for(int i=0; i<=b_cursor; i++){
                A[i]=B[i];
            }
        }
        return;
    }
}