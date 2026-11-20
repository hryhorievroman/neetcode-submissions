class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numbersMap = new HashMap<>();
        for (int i : nums) {
            numbersMap.put(i, numbersMap.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (int i : numbersMap.keySet()) {
            int frequency = numbersMap.get(i);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(i);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int freq : buckets[i]) {
                    result[index++] = freq;
                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
