class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int currSeq = 1;
            if (!set.contains(curr - 1)) {
                while (set.contains(curr + 1)) {
                    curr++;
                    currSeq++;
                }
            }
            result = Math.max(currSeq, result);
        }
        return result;
    }
}
