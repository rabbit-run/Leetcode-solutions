/*
Given a binary tree, return the inorder traversal of its nodes' values.
Recursive solution is trivial, could you do it iteratively?
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                TreeNode current = s.pop();
                traversal.add(current.val);
                if (current.right != null) {
                    root = current.right;
                }
            }
        }
        return traversal;
    }
}