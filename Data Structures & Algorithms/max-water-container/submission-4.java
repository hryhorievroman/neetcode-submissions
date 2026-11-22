class Solution {
    public int maxArea(int[] h) {
        if (h == null || h.length < 2) {
            return 0;
        }

        int result = 0;
        int left = 0;
        int right = h.length - 1;

        while (left < right) {
            int height = Math.min(h[left], h[right]);
            int width = right - left;
            result = Math.max(result, height * width);

            if (h[left] < h[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
