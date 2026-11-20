class TimeMap {
    Map<String, List<Node>> storage;

    private class Node {
        int timestamp;
        String value;

        public Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        storage = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        storage.putIfAbsent(key, new ArrayList<>());
        storage.get(key).add(new Node(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!storage.containsKey(key))
            return "";

        List<Node> nodes = storage.get(key);

        int left = 0;
        int right = nodes.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nodes.get(mid).timestamp == timestamp) {
                return nodes.get(mid).value;
            } else if (nodes.get(mid).timestamp < timestamp) {
                result = nodes.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
