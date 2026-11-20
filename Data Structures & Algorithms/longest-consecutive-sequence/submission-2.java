class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int longest = 1;
                while (set.contains(num + longest)) {
                    longest++;
                }
                result = Math.max(result, longest);
            }
        }
        return result;
    }
}
