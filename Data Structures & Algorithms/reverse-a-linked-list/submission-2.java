/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

  prev(newHead) <- 1(newHead) -> null
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = head;
        ListNode prev = null;
        ListNode temp = null;

        while (newHead != null) {
            temp = newHead.next;
            newHead.next = prev;
            prev = newHead;
            newHead = temp;
        }
        return prev;
    }
}
