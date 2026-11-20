class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deq = new ArrayDeque<>();

        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!deq.isEmpty() && deq.peekFirst() < i - k + 1) {
                deq.pollFirst();
            }

            while (!deq.isEmpty() && nums[i] > nums[deq.peekLast()]) {
                deq.pollLast();
            }

            deq.offerLast(i);

            if (i >= k - 1) {
                result[pointer++] = nums[deq.peekFirst()];
            }
        }
        return result;
    }
}
/*    0 1 2 3 4 5 6
     [1,2,1,0,4,2,6], k = 3
     i = 2;
     i - k + 1 = 2 - 3 + 1 = 0


*/