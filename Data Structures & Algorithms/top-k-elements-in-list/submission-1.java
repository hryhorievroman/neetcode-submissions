class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numbers = new HashMap<>();
        PriorityQueue<Integer> queue =
            new PriorityQueue<>((a, b) -> numbers.get(b) - numbers.get(a));

        for (int i : nums) {
            numbers.put(i, numbers.getOrDefault(i, 0) + 1); // O(n)
        }

        queue.addAll(numbers.keySet()); // O(nlogn)

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) { //O(k)
            result[i] = queue.poll();
        }

        return result;
    }
}

// time compl - O(n)
// space comple - O(n + m = n)
