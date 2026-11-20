class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] result = new int[temp.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temp.length; i++) {
            while (!stack.empty() && temp[i] > temp[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
