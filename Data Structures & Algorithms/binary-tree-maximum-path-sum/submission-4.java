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
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPath(root);
        return maxPath;
    }

    private int getMaxPath(TreeNode node) {
        if (node == null)
            return 0;

        int maxLeft = Math.max(getMaxPath(node.left), 0);
        int maxRight = Math.max(getMaxPath(node.right), 0);

        maxPath = Math.max(maxPath, node.val + maxLeft + maxRight);

        return Math.max(maxLeft, maxRight) + node.val;
    }
}
