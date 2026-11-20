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
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            size++;
        }

        if (size < k) {
            return head;
        }

        pointer = head;
        ListNode prev = null;

        for (int i = 0; i < k; i++) {
            ListNode next = pointer.next;
            pointer.next = prev;
            prev = pointer;
            pointer = next;
        }

        head.next = reverseKGroup(pointer, k);

        return prev;
    }
}

