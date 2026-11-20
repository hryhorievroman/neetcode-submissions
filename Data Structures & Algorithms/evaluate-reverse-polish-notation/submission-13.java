class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for (String s : tokens) {
            switch (s) {
                case "+" -> {
                    if (nums.size() >= 2) {
                        int a = nums.pop();
                        int b = nums.pop();
                        nums.push(b + a);
                    }
                }

                case "-" -> {
                    if (nums.size() >= 2) {
                        int a = nums.pop();
                        int b = nums.pop();
                        nums.push(b - a);
                    }
                }

                case "*" -> {
                    if (nums.size() >= 2) {
                        int a = nums.pop();
                        int b = nums.pop();
                        nums.push(b * a);
                    }
                }

                case "/" -> {
                    if (nums.size() >= 2) {
                        int a = nums.pop();
                        int b = nums.pop();

                        nums.push(b / a);
                    }
                }

                default -> nums.push(Integer.parseInt(s));
            }
        }

        return nums.pop();
    }
}
