class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0]; // 1
        int fast = nums[0]; // 1

        do {
            slow = nums[slow]; //              nums[1] = 2, nums[2] = 3
            fast = nums[nums[fast]]; //        nums[2] = 3, nums[2] = 3
        } while (slow != fast); //             2 != 3,       3 == 3, slow = fast = nums[2] = 3

        slow = nums[0]; // slow = 1

        while (slow != fast) { //  slow(1) != fast(3)
            slow = nums[slow]; //  slow(nums[1]) = 2  
            fast = nums[fast]; //  fast(nums[3]) = 2
        }
        return slow;
    }
}