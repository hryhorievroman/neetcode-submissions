class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("*").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int pointer = 0;

        while (pointer < str.length()) {
            int delimeterPos = str.indexOf("*", pointer);
            int length = Integer.parseInt(str.substring(pointer, delimeterPos));
            int start = delimeterPos + 1;
            int end = start + length;
            result.add(str.substring(start, end));
            pointer = end;
        }

        return result;
    }
}

/*
Hello, World -> [5*Hello, 5*World]

0123456789 10 11 12 13
5*Hello5*W o  r l  d


*/
