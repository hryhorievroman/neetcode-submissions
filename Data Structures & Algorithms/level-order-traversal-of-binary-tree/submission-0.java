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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> result = new ArrayList();

        if (root != null) {
            nodes.add(root);
        }

        while (!nodes.isEmpty()) {
            
            List<Integer> currLvl = new ArrayList<>(nodes.size());
            int size = nodes.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = nodes.poll();

                currLvl.add(curr.val);

                if (curr.left != null) {
                    nodes.add(curr.left);
                }

                if (curr.right != null) {
                    nodes.add(curr.right);
                }
            }

            result.add(currLvl);
        }

        return result;
    }
}
