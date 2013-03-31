/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode previous = null;
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            int sum = carry + getVal(l1) + getVal(l2);
            if (sum >=10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            if (res == null) {
                res = new ListNode(sum);
                previous = res;
            } else {
                previous.next = new ListNode(sum);
                previous = previous.next;
            }
            if (l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            previous.next = new ListNode(1);
        }
        
        return res;
    }
    
    public int getVal(ListNode l) {
        if (l==null) {
            return 0;
        }
        else {
            return l.val;
        }
    }
}