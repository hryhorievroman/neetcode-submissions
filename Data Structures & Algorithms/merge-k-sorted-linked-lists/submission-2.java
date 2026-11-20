/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nums = new ArrayList<>();

        for (ListNode list : lists) {
            while (list != null) {
                nums.add(list.val);
                list = list.next;
            }
        }

        Collections.sort(nums);

        ListNode result = new ListNode(0);
        ListNode next = result;

        for (int i : nums) {
            ListNode newNode = new ListNode(i);
            next.next = newNode;
            next = next.next;
        }

        return result.next;
    }
}
