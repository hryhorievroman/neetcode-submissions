class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int pointer = 0;

        while(pointer < str.length()){
            int symbol = str.indexOf('#', pointer);
            int length = Integer.parseInt(str.substring(pointer, symbol));
            int wordStart = symbol + 1;
            int wordEnd = wordStart + length;
            result.add(str.substring(wordStart, wordEnd));
            System.out.println(wordEnd);
            pointer = wordEnd;
        }

        return result;
    }
}


/*
-> Hello, World -> 5#Hello5#World

*/