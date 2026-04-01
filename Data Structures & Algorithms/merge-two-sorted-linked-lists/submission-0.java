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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = null; 
        ListNode last = null; 
        ListNode l1p = list1; 
        ListNode l2p = list2; 

        while (l1p != null && l2p != null) {
            int insertVal; 
            if (l1p.val <= l2p.val) {
                insertVal = l1p.val;
                l1p = l1p.next; 
            } else {
                insertVal = l2p.val; 
                l2p = l2p.next; 
            }
            ListNode node = new ListNode(insertVal);
            if (ans == null) {
                    ans = node; 
                    last = node; 
            } else {
                last.next = node; 
                last = node; 
            }
        }

        while (l1p != null) {
            ListNode node = new ListNode(l1p.val);
            if (ans == null) {
                ans = node; 
                last = node; 
            } else {
                last.next = node; 
                last = node; 
            }
            l1p = l1p.next; 
        }

        while (l2p != null) {
            ListNode node = new ListNode(l2p.val);
            if (ans == null) {
                ans = node; 
                last = node; 
            } else {
                last.next = node; 
                last = node; 
            }
            l2p = l2p.next; 
        }

        return ans; 
    }
}