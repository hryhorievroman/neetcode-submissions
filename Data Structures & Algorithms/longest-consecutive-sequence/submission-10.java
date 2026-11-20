class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int result = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentPeak = 1;
                int currNum = num;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    currentPeak++;
                }
                result = Math.max(currentPeak, result);
            }
        }

        return result;
    }
}
