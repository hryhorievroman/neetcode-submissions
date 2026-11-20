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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> nodes = new LinkedList<>();

        if (root != null) {
            nodes.add(root);
        }

        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();

            if (curr.val > p.val && curr.val > q.val) {
                nodes.add(curr.left);
            } else if (curr.val < p.val && curr.val < q.val) {
                nodes.add(curr.right);
            } else {
                return curr;
            }
        }
        return null;
    }
}
