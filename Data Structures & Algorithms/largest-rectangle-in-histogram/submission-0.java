class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[i] < heights[stack.peek()]) {
                int heightIndex = stack.pop();
                int height = heights[heightIndex];
                int leftBoundary = stack.empty() ? -1 : stack.peek();

                int width = i - leftBoundary - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            int heightIndex = stack.pop();
            int height = heights[heightIndex];
            int leftBoundary = stack.empty() ? -1 : stack.peek();

            int width = heights.length - leftBoundary - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
