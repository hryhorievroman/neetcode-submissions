class Solution {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case ')' -> {
                    if (chars.empty() || chars.peek() != '(') {
                        return false;
                    } else {
                        chars.pop();
                    }
                }

                case ']' -> {
                    if (chars.empty() || chars.peek() != '[') {
                        return false;
                    } else {
                        chars.pop();
                    }
                }

                case '}' -> {
                    if (chars.empty() || chars.peek() != '{') {
                        return false;
                    } else {
                        chars.pop();
                    }
                }

                default -> chars.push(c);
            }
        }

        return chars.empty();
    }
}
