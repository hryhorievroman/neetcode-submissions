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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inOrderDFS(root, k, values);

        return values.get(values.size() - 1);
    }

    private void inOrderDFS(TreeNode root, int goal, List<Integer> result) {
        if (root == null || result.size() == goal)
            return;

        inOrderDFS(root.left, goal, result);
        if (result.size() == goal) {
            return;
        }
        result.add(root.val);
        inOrderDFS(root.right, goal, result);
    }
}
