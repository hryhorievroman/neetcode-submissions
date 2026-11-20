class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sortedArr = str.toCharArray();
            Arrays.sort(sortedArr);
            String sortedStr = new String(sortedArr);
            map.computeIfAbsent(sortedStr, list -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
