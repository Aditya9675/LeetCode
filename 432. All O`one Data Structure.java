/*

Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.

Implement the AllOne class:

AllOne() Initializes the object of the data structure.
inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
Note that each function must run in O(1) average time complexity.

 

Example 1:

Input
["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
Output
[null, null, null, "hello", "hello", null, "hello", "leet"]

Explanation
AllOne allOne = new AllOne();
allOne.inc("hello");
allOne.inc("hello");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "hello"
allOne.inc("leet");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "leet"
 

Constraints:

1 <= key.length <= 10
key consists of lowercase English letters.
It is guaranteed that for each call to dec, key is existing in the data structure.
At most 5 * 104 calls will be made to inc, dec, getMaxKey, and getMinKey.

*/

class AllOne {

    class Node {
        Set<String> keys;
        int val;
        Node prev = null;
        Node next = null;
        
        Node(int val) {
            this.val = val;
            this.keys = new HashSet<>();
        }
        
        Node(String key, int val) {
            this(val);
            this.keys.add(key);
        }
    }
    
    Map<String, Node> map;
    Node head;
    Node tail;
    
    public AllOne() {
        this.map = new HashMap<>();
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.prev = tail;
        this.tail.next = head;
    }
    
    private void deleteNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }
    
    private void removeKeyFromNode(String key, Node node) {
        node.keys.remove(key);
        if (node.keys.isEmpty()) {
            deleteNode(node);
        }
    }
    
    private void insertNext(Node node, Node newNode) {
        node.next.prev = newNode;
        newNode.next = node.next;
        node.next = newNode;
        newNode.prev = node;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node.val + 1 == node.next.val) {
                node.next.keys.add(key);
                map.put(key, node.next);
            } else {
                Node newNode = new Node(key, node.val + 1);
                insertNext(node, newNode);
                map.put(key, newNode);
            }
            removeKeyFromNode(key, node);
        } else {
            if (tail.next.val == 1) {
                tail.next.keys.add(key);
                map.put(key, tail.next);
            } else {
                Node newNode = new Node(key, 1);
                insertNext(tail, newNode);
                map.put(key, newNode);
            }
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        
        Node node = map.get(key);
        if (node.val == 1) {
            map.remove(key);
        } else if (node.val - 1 == node.prev.val) {
            node.prev.keys.add(key);
            map.put(key, node.prev);
        } else {
            Node newNode = new Node(key, node.val - 1);
            map.put(key, newNode);
            insertNext(node.prev, newNode);
        }
        removeKeyFromNode(key, node);
    }

    public String getMaxKey() {
        return head.prev.keys.isEmpty() ? "" : head.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return tail.next.keys.isEmpty() ? "" : tail.next.keys.iterator().next();
    }
}
