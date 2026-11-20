/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodes = new HashMap<>();

        Node pointer = head;

        while (pointer != null) {
            nodes.put(pointer, new Node(pointer.val));
            pointer = pointer.next;
        }

        pointer = head;

        while (pointer != null) {
            Node copy = nodes.get(pointer);
            copy.next = nodes.get(pointer.next);
            copy.random = nodes.get(pointer.random);
            pointer = pointer.next;
        }

        return nodes.get(head);
    }
}
