/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
            Map<Node, Node> oldNewMap = new HashMap<>();
            Node temp = head; 
            while ( temp != null ) {
                Node newNode = new Node(temp.val);
                oldNewMap.put(temp, newNode);
                temp = temp.next; 
            }
            oldNewMap.put(null, null);

            temp = head; 
            while ( temp != null ) {
                Node newNode = oldNewMap.get(temp);
                newNode.next = oldNewMap.get(temp.next); 
                newNode.random = oldNewMap.get(temp.random);
                temp = temp.next; 
            }


            return oldNewMap.get(head);

    }
}
