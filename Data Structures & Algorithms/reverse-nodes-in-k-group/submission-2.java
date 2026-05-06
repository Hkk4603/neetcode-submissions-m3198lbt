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
        // dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 ...
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy; 

        while (true) {
            ListNode kthNode = getKthNode(groupPrev, k);
            if (kthNode == null) break;
            ListNode groupNext = kthNode.next; 

            ListNode prev = groupNext; 
            ListNode curr = groupPrev.next; 
            while (curr != groupNext) {
                ListNode temp = curr.next; 
                curr.next = prev;
                prev = curr; 
                curr = temp;
            }

            ListNode temp = groupPrev.next; // temp = dummy.next = 1 // only for the first iteration
            groupPrev.next = kthNode; // groupPrev.next = dummy.next = 3 if k = 3 // only for the first iteration
            groupPrev = temp; // groupPrev = 1;
        }

        return dummy.next; 
    }

    private ListNode getKthNode(ListNode curr, int k){
        while (curr != null && k > 0) {
            curr = curr.next; 
            k -= 1; 
        }

        return curr; 
    }

}
