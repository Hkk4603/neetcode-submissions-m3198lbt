public class Node {
    int key; 
    int val; 
    Node next; 
    Node prev;

    public Node (int key, int val) {
        this.key = key; 
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    private int cap; 
    private HashMap<Integer, Node> cache; 
    private Node lru; 
    private Node mru; 

    public LRUCache(int capacity) {
        this.cap = capacity; 
        this.cache = new HashMap<>(); 
        this.lru = new Node(0, 0);
        this.mru = new Node(0, 0); 
        this.lru.next = this.mru; 
        this.mru.prev = this.lru; 
    }

    private void remove(Node node) {
        Node leftNeighbor = node.prev;
        Node rightNeighbor = node.next; 
        leftNeighbor.next = rightNeighbor;
        rightNeighbor.prev = leftNeighbor;
    }

    private void insert(Node node) {
        Node prev = this.mru.prev;

        prev.next = node; 
        node.prev = prev;

        node.next = this.mru;
        this.mru.prev = node;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node); 
            return node.val;
        }
        return -1; 
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        Node newNode = new Node(key, value); 
        cache.put(key, newNode); 
        insert(newNode);

        if (cache.size() > cap) {
            Node lru = this.lru.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
