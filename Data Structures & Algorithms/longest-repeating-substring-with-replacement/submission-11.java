class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int result = 0;
        int maxFreq = 0;
        int[] chars = new int[26];

        for (int r = 0; r < s.length(); r++) {
            chars[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, chars[s.charAt(r) - 'A']);

            while (r - l + 1 - maxFreq > k) {
                chars[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
