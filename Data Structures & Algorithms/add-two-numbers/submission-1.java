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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1h = l1, l2h = l2; 
        ListNode lans = new ListNode(0); 
        ListNode ans = lans;
        int carry = 0;

        while ( l1h != null || l2h != null || carry != 0 ) {
            int sum = carry;

            if ( l1h != null ) {
                sum += l1h.val;
                l1h = l1h.next;
            }

            if ( l2h != null ) {
                sum += l2h.val;
                l2h = l2h.next;
            }

            int val = sum % 10; 
            carry = sum / 10; 
            ListNode node = new ListNode(val); 
            lans.next = node; 
            lans = node;
        }

        return ans.next; 

    }
}
