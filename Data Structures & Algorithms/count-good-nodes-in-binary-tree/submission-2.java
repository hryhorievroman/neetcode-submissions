/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int prevVal) {
        if (node == null)
            return 0;

        int goodValues = 0;

        if (node.val >= prevVal) {
            goodValues = 1;
            prevVal = node.val;
        }

        goodValues += dfs(node.left, prevVal);
        goodValues += dfs(node.right, prevVal);

        return goodValues;
    }
}
