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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;

        ListNode curr = head;

        while (curr != null) {
            size++;
            curr = curr.next;
        }

        if (size < k)
            return head;

        curr = head;
        ListNode prev = null;
        ListNode next = null;

        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null : null <- 1 <- 2 <- 3 && 4 -> 5 -> 6 -> null
        
        
        // 1 -> 2 -> 3 -> 4 -> null : 3 -> 2 -> 1 -> null 4 -> null
        ListNode sec = reverseKGroup(next,k);
        head.next = sec;

        return prev;
    }
}
