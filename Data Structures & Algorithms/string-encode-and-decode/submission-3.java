class Solution {
    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for (String str : strs) {
            encode.append(str.length()).append("#").append(str);
        }

        return encode.toString();
    }

    public List<String> decode(String str) {
        List<String> decode = new ArrayList<>();
        int index = 0;

        while (index < str.length()) {
            int j = index;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(index, j));
            String decoded = str.substring(j + 1, j + 1 + length);
            decode.add(decoded);
            index = j + 1 + length;
        }

        return decode;
    }
}
