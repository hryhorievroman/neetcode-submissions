class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums) {
            if (resultSet.contains(i)) {
                return true;
            }
            resultSet.add(i);
        }
        return false;
    }
}