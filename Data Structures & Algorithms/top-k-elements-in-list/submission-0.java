class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numbers = new HashMap<>();
        PriorityQueue<Integer> queue =
            new PriorityQueue<>((a, b) -> numbers.get(b) - numbers.get(a));

        for (int i : nums) {
            numbers.put(i, numbers.getOrDefault(i, 0) + 1);
        }

        for (int key : numbers.keySet()) {
            queue.add(key);
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}
