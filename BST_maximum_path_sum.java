/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return 6.
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
    private int maxAcrossTree = 0;
    
    public int maxPathSum(TreeNode root) {
        this.maxAcrossTree = root.val;
        int tmp = getMax(root);
        int res = this.maxAcrossTree;
        this.maxAcrossTree = 0;
        return res;
    }
    
    public int getMax(TreeNode node) {
        if (node == null) return 0;
        
        int left = getMax(node.left);
        int right = getMax(node.right);
        int localMax = node.val;
        if (left > 0) localMax += left;
        if (right > 0) localMax += right;
        this.maxAcrossTree = Math.max(maxAcrossTree, localMax);
        return Math.max(node.val, Math.max(node.val+left, node.val+right));
    }
}
