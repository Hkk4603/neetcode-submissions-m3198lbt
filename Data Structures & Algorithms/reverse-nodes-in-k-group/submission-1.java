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

        if (k == 1) return head; 
        Stack<ListNode> toReverse = new Stack<>();
        Queue<ListNode> toLink = new LinkedList<>(); 

        ListNode temp = head; 

        while (temp != null) {
            // insert to reverse
            while (temp != null && toReverse.size() < k) {
                toReverse.push(temp);
                // System.out.println("debug toReverse: " + temp.val);
                temp = temp.next;
            }
            // System.out.println("break");

            // pop and link 
            if (temp == null && toReverse.size() < k) {
                ListNode startNode = null;
                while (!toReverse.isEmpty()) {
                    startNode = toReverse.pop();
                }
                toLink.add(startNode);
                break;
            } else {
                ListNode curr = toReverse.pop();
                ListNode toAdd = null;
                // System.out.println("debug curr: " + curr.val); 
                ListNode prev = null;
                while (!toReverse.isEmpty()) {
                    if (toAdd == null) toAdd = curr;
                    prev = curr; 
                    curr = toReverse.pop(); 
                    prev.next = curr; 
                }
                // System.out.println("debut toLink: " + toAdd.val);
                curr.next = null;
                toLink.add(toAdd);
            }
        }

        ListNode result = null;
        ListNode prevLastNode = null;
        ListNode startNode = null; 
        while (!toLink.isEmpty()) {
            startNode = toLink.poll();
            // System.out.println("debug: " + startNode.val);
            if (result == null) {
                result = startNode;
            }
            if (prevLastNode != null) 
                prevLastNode.next = startNode;
            while (startNode.next != null) {
                // System.out.println("debug iterate: " + startNode.val);
                prevLastNode = startNode;
                startNode = startNode.next;
            }
            prevLastNode = startNode;
        }

        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr != null ? curr.next : null;
        while ( next != null ) {
            curr.next = prev;
            prev = curr; 
            curr = next; 
            next = curr.next;
        }   

        if (curr != null)
            curr.next = prev;

        return curr; 
    }
}
