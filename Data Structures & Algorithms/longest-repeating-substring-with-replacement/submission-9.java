class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int result = 0;
        int maxFreq = 0;
        int[] chars = new int[26];
//A
        for (int r = 0; r < s.length(); r++) {
            chars[s.charAt(r) - 'A']++; // A : 1
            maxFreq = Math.max(maxFreq, chars[s.charAt(r) - 'A']); // 1

            while (r - l + 1 - maxFreq > k) {
                chars[s.charAt(l) - 'A']--;
                l++;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
