/*
Given an array where elements are sorted in ascending order,
convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        
        TreeNode root = new TreeNode(num[num.length/2]);
        genTree(num, 0, num.length/2, root, true);
        genTree(num, num.length/2+1, num.length, root, false);
        
        return root;
        
    }
    
    private void genTree(int[] num, int left, int right,
        TreeNode parent, Boolean isLeft) {
        
        if (left >= right) return;
        
        int mid = (right+left)/2;
        TreeNode node = new TreeNode(num[mid]);
        
        if (isLeft)
            parent.left = node;
        else
            parent.right = node;
        
        genTree(num, left, mid, node, true);
        genTree(num, mid+1, right, node, false);
        
        return;
    }
}