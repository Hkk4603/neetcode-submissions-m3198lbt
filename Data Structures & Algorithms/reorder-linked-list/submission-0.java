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
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head; 

        // finding the mid node of the linked list
        while ( fast != null && fast.next != null ) {
            slow = slow.next; 
            fast = fast.next.next;
        }

        // now slow is pointing to the mid
        ListNode secondHalf = slow.next; // set secondHalf var
        ListNode prev = slow.next = null; // set set the prev or secondHalf and last node of
        // first half to null

        // rever the second half of nodes
        while ( secondHalf != null ) {
            ListNode temp = secondHalf.next; 
            secondHalf.next = prev; 
            prev = secondHalf; 
            secondHalf = temp;
        }

        ListNode firstHalfPtr = head; 
        ListNode secondHalfPtr = prev; 

        while ( secondHalfPtr != null ) {
            ListNode temp1 = firstHalfPtr.next; 
            ListNode temp2 = secondHalfPtr.next; 
            firstHalfPtr.next = secondHalfPtr; 
            secondHalfPtr.next = temp1; 
            firstHalfPtr = temp1; // moving the pointer forward 
            secondHalfPtr = temp2; // moving the pointer forward
        }


    }
}
