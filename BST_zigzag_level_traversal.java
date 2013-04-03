/*
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> parents = new Stack<TreeNode>();
        Stack<TreeNode> children = new Stack<TreeNode>();
        ArrayList<Integer> levelVals = new ArrayList<Integer>();
        parents.push(root);
        
        boolean leftToRight = true;
        
        while(!parents.isEmpty()) {
            while(!parents.isEmpty()) {
                TreeNode currentNode = parents.pop();
                levelVals.add(currentNode.val);
                if (leftToRight) {
                    if (currentNode.left != null) children.push(currentNode.left);
                    if (currentNode.right != null) children.push(currentNode.right);
                }
                else {
                    if (currentNode.right != null) children.push(currentNode.right);
                    if (currentNode.left != null) children.push(currentNode.left);
                }
            }
            res.add(levelVals);
            levelVals = new ArrayList<Integer>();
            parents = children;
            children = new Stack<TreeNode>();
            leftToRight = !leftToRight;
        }
        return res;
    }
}