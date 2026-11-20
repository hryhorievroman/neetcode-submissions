class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numbersMap = new HashMap<>();
        for (int i : nums) {
            numbersMap.put(i, numbersMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> heap =
            new PriorityQueue<>((a, b) -> numbersMap.get(b) - numbersMap.get(a));

        for (int i : numbersMap.keySet()) {
            heap.add(i);
        }

        int[] result = new int[k];

        for (int i = 0; i < result.length; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
