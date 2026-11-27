class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(
        int[] arr, List<List<Integer>> result, int index, List<Integer> currList) {
        result.add(new ArrayList<>(currList));

        for (int i = index; i < arr.length; i++) {
            currList.add(arr[i]);
            backtrack(arr, result, i + 1, currList);
            currList.remove(currList.size() - 1);
        }
    }
}
