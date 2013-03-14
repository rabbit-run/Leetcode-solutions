/*
 Given a binary tree, return the level order traversal of its nodes' values.
 (ie, from left to right, level by level).
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> parents = new ArrayList<TreeNode>();
        ArrayList<Integer> childrenVal = new ArrayList<Integer>();
        ArrayList<TreeNode> children = new ArrayList<TreeNode>();
        
        parents.add(root);
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(root.val);
        res.add(first);
        
        while (!parents.isEmpty()) {
            for (TreeNode t : parents) {
                if (t.left != null) {
                    childrenVal.add(t.left.val);
                    children.add(t.left);
                }
                if (t.right != null) {
                    childrenVal.add(t.right.val);
                    children.add(t.right);
                }
            }
            if (!childrenVal.isEmpty())
                res.add(new ArrayList<Integer>(childrenVal));
            childrenVal.clear();
            parents.clear();
            for (TreeNode t: children) {
                parents.add(t);    
            }
            children.clear();
        }
        
        return res;
    }
}