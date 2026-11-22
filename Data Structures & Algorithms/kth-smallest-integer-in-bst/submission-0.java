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
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            list.add(curr.val);

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        Collections.sort(list);

        return list.get(k - 1);
    }
}
