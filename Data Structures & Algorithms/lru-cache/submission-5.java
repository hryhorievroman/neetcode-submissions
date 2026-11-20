class LRUCache {
    int capacity;
    Map<Integer, Node> nodes;
    Node tail = new Node();
    Node head = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodes = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        if (nodes.containsKey(key)) {
            Node curr = nodes.get(key);
            removeNode(curr);
            addNode(curr);
            result = curr.val;
        }
        return result;
    }

    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            Node curr = nodes.get(key);
            removeNode(curr);
            curr.val = value;
            addNode(curr);
        } else {
            Node newNode = new Node();
            newNode.val = value;
            newNode.key = key;
            if (capacity == nodes.size()) {
                Node lru = tail.prev;
                removeNode(lru);
                nodes.remove(lru.key);
            }
            nodes.put(key, newNode);
            addNode(newNode);
        }
    }

    private void addNode(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
    // head <-> a <-> b <-> tail
    private void removeNode(Node node) {
        Node nodeNext = node.next;
        Node nodePrev = node.prev;
        nodeNext.prev = nodePrev;
        nodePrev.next = nodeNext;
    }

    class Node {
        int key;
        int val;
        Node next;
        Node prev;
    }
}
