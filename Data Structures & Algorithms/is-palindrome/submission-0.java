class Solution {
    public boolean isPalindrome(String s) {
        String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int left = 0, right = cleanString.length() - 1; left < right; left++, right--) {
            if (cleanString.charAt(left) != cleanString.charAt(right)) {
                System.out.println(cleanString.charAt(left) + "-" + cleanString.charAt(right));
                return false;
            }
        }
        return true;
    }
}
