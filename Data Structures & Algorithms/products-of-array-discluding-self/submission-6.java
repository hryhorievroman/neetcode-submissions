class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int[] leftSum = new int[len];
        int[] rightSum = new int[len];

        int first = 1;
        leftSum[0] = first;
        rightSum[len - 1] = first;

        for (int i = 1; i < leftSum.length; i++) {
            leftSum[i] = leftSum[i - 1] * nums[i - 1];
        }

        for (int i = rightSum.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            result[i] = leftSum[i] * rightSum[i];
        }

        return result;
    }
}
