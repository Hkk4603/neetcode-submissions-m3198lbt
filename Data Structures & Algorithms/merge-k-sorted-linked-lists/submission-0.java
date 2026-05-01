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
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (ListNode a, ListNode b) -> a.val - b.val);
        HashMap<ListNode, Integer> hm = new HashMap<>(); 
        ListNode head = null, last = null;
        // initializing pq;
        for(int i = 0; i < lists.length; i++) {
            pq.add(lists[i]);
            hm.put(lists[i], i);
        }

        while (!pq.isEmpty()) {
            ListNode priorityNode = pq.poll();
            int listIdx = hm.getOrDefault(priorityNode, -1);
            if ( listIdx != -1 && priorityNode != null) {
                hm.remove(priorityNode);
                ListNode nextNode = priorityNode.next;
                if (nextNode != null)
                    pq.add(nextNode);
                hm.put(nextNode, listIdx);
                if (head == null) {
                    head = priorityNode;
                    last = priorityNode; 
                } else {
                    last.next = priorityNode; 
                    last = last.next;
                }
            } else {
                System.out.println("Something is wrong");
            }   
        }

        Iterator<ListNode> iterator = pq.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next().val + " ");
        }
        return head;
    } 
}
