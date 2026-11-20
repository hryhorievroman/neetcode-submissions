class Solution {
    public int maxArea(int[] heights) {
        if (heights == null || heights.length < 2)
            return 0;
        int maxArea = 0;

        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, width * height);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
