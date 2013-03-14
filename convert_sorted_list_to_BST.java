/*
Given a singly linked list where elements are sorted in ascending order, 
convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode listTracker;
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        int len = lenList(head);
        listTracker = head;
        return sortedListToBST(0, len);
    }
    
    public TreeNode sortedListToBST(int left, int right) {
        if (left >= right) return null;
        
        int mid = left + (right-left)/2;
        TreeNode leftNode = sortedListToBST(left, mid);
        TreeNode parent = new TreeNode(listTracker.val);
        listTracker = listTracker.next;
        parent.left = leftNode;
        parent.right = sortedListToBST(mid+1, right);
        return parent;
    }
    
    private int lenList(ListNode head) {
        if (head == null) return 0;
        
        int len = 1;
        while (head.next != null) {
            len ++;
            head = head.next;
        }
        return len;
    }
}