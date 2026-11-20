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
    int longestPath;

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return longestPath;
    }

    private int getDiameter(TreeNode node) {
        if (node == null)
            return 0;

        int leftDepth = getDiameter(node.left);
        int rightDepth = getDiameter(node.right);

        longestPath = Math.max(longestPath, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
