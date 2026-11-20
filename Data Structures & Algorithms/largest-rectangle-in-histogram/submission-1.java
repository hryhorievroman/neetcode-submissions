class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.empty() && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int leftBoundary = stack.empty() ? -1 : stack.peek();
                int w = i - leftBoundary - 1;

                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            int h = heights[stack.pop()];
            int leftBoundary = stack.empty() ? -1 : stack.peek();
            int w = len - leftBoundary - 1;

            maxArea = Math.max(maxArea, h * w);
        }

        return maxArea;
    }
}
