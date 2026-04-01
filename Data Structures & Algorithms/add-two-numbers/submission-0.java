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
        ListNode ans = null, lans = null; 
        int carry = 0;
        boolean first = true; 

        while (l1h != null && l2h != null) {
            int res = carry + l1h.val + l2h.val; // 0 + 9 + 9 = 18
            carry = res / 10; // 1
            int val = res % 10; // 8
            ListNode node = new ListNode(val);
            if (first) {
                ans = node; 
                lans = node; 
                first = false;
            } else {
                if (lans != null)
                    lans.next = node;
                lans = node;
            }
            l1h = l1h.next;
            l2h = l2h.next;
        }

        ListNode temp = null;
        if (l1h != null) {
            temp = l1h;
        } else if (l2h != null) {
            temp = l2h;
        }

        while (temp != null) {
            int res = carry + temp.val;
            carry = res / 10;
            int val = res % 10;
            ListNode node = new ListNode(val);
            lans.next = node; 
            lans = node;
            temp = temp.next; 
        }

        if ( carry != 0 ) {
            ListNode node = new ListNode(carry);
            lans.next = node; 
            lans = node;
        }

        return ans; 

    }
}
