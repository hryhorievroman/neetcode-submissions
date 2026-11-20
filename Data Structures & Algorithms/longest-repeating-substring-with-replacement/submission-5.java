class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int left = 0;
        int result = 0;
        int[] chars = new int[26];

        for (int right = 0; right < s.length(); right++) {
            chars[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, chars[s.charAt(right) - 'A']);

            while (right - left + 1 - maxFreq > k) {
                chars[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
