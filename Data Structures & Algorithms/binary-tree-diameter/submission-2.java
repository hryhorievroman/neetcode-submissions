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
    int maxDiam = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int longestPath = getLongestPath(root);

        return maxDiam;
    }

    private int getLongestPath(TreeNode node) {
        if (node == null)
            return 0;

        int leftPath = getLongestPath(node.left);
        int rightPath = getLongestPath(node.right);

        maxDiam = Math.max(maxDiam, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }
}
