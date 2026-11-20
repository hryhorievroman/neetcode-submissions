class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        Set<Character> chars = new HashSet<>();
        int result = 0;

        while (r < s.length()) {
            while (chars.contains(s.charAt(r))) {
                chars.remove(s.charAt(l));
                l++;
            }
            chars.add(s.charAt(r));
            r++;
            result = Math.max(result, chars.size());
        }

        return result;
    }
}
