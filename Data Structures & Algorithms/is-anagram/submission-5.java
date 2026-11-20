class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> resultMap = new HashMap<>();
        for(char c : s.toCharArray()){
            resultMap.put(c, resultMap.getOrDefault(c, 0) + 1);
        } 
        for(char c : t.toCharArray()){
            resultMap.put(c, resultMap.getOrDefault(c, 0) - 1);
        }

        for(char c : resultMap.keySet()){
            if(resultMap.get(c) > 0){
                return false;
            }
        }

        return true;
    }
}
