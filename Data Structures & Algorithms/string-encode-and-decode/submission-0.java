class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            for (char c : s.toCharArray()) {
                int n = c;
                sb.append(n).append(",");
            }
            sb.append(".");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sbRes = new StringBuilder();
        StringBuilder sbNum = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (c == ',') {
                int ascii = Integer.parseInt(sbNum.toString());
                sbRes.append((char) ascii);
                sbNum.setLength(0);
            } else if (c == '.') {
                result.add(sbRes.toString());
                sbRes.setLength(0);
            } else {
                sbNum.append(c);
            }
        }
        return result;
    }
}
