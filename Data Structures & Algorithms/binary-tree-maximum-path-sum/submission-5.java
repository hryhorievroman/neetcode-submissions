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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getSum(root);
        return maxSum;
    }

    private int getSum(TreeNode node) {
        if (node == null)
            return 0;

        int maxLeft = Math.max(0, getSum(node.left));
        int maxRight = Math.max(0, getSum(node.right));

        maxSum = Math.max(maxSum, node.val + maxLeft + maxRight);

        return node.val + Math.max(maxLeft, maxRight);
    }
}
