class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        int[] mergedArr = new int[l];
        for (int i = 0; i < nums1.length; i++) {
            mergedArr[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            mergedArr[i + nums1.length] = nums2[i];
        }

        Arrays.sort(mergedArr);

        double result = 0.0;
        if (l % 2 != 0) {
            result = mergedArr[(l - 1) / 2];
        } else {
            result = (double) (mergedArr[(l - 1) / 2] + mergedArr[((l - 1) / 2) + 1]) / 2;
        }

        return result;
    }
}
