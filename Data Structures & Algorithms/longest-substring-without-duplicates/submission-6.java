class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        Set<Character> nums = new HashSet<>();
        while (right < s.length()) {
            while (nums.contains(s.charAt(right))) {
                nums.remove(s.charAt(left));
                left++;
            }
            nums.add(s.charAt(right));
            result = Math.max(result, nums.size());
            right++;
        }

        return result;
    }
}
