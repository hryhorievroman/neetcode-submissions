class Solution {
    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for (String s : strs) {
            encode.append(s.length()).append("#").append(s);
        }

        return encode.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, j));

            result.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }

        return result;
    }
}
