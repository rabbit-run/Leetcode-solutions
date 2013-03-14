
/*
Given a binary tree, return the inorder traversal of its nodes' values.
Note: Recursive solution is trivial, could you do it iteratively?
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
    private ArrayList<Integer> traversal;
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        this.traversal = new ArrayList<Integer>();
        inorderTravel(root);
        return this.traversal;
    }
    
    private void inorderTravel(TreeNode root) {
        if (root == null) return;
        
        inorderTravel(root.left);
        this.traversal.add(root.val);
        inorderTravel(root.right);
    }
}