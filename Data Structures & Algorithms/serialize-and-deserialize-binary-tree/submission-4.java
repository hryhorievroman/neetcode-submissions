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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringJoiner sj = new StringJoiner(",");
        dfsSerialize(root, sj);
        return sj.toString();
    }

    private void dfsSerialize(TreeNode node, StringJoiner sj) {
        if (node == null) {
            sj.add("#");
            return;
        }

        sj.add("" + node.val);

        dfsSerialize(node.left, sj);
        dfsSerialize(node.right, sj);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));

        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> input) {
        var val = input.poll();

        if (val == null || "#".equals(val)) {
            return null;
        }

        TreeNode newNode = new TreeNode(Integer.parseInt(val));
        newNode.left = buildTree(input);
        newNode.right = buildTree(input);

        return newNode;
    }
}
