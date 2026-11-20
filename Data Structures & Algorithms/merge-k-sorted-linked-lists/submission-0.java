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
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }

        ListNode result = new ListNode(0);
        ListNode next = result;

        while (!heap.isEmpty()) {
            ListNode curr = heap.poll();
            next.next = curr;
            next = next.next;

            curr = curr.next;

            if (curr != null) {
                heap.offer(curr);
            }
        }

        return result.next;
    }
}
