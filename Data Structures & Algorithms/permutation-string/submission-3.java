class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 > l2)
            return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < l1; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if (matches(arr1, arr2)) {
            return true;
        }

        for (int i = l1; i < l2; i++) {
            arr2[s2.charAt(i) - 'a']++;
            arr2[s2.charAt(i - l1) - 'a']--;

            if (matches(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
