/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        Node current = head;
        while (current != null) {
            if (current.child != null){
                Node temp = flatten (current.child);
                //get to the end of the temp
                Node tTail = temp;
                while (tTail.next != null) {
                    tTail = tTail.next;
                }
                tTail.next = current.next;
                if (current.next != null) current.next.prev = tTail;
                temp.prev = current;
                current.next = temp;
                current.child = null;
                current = tTail;
            }
            current = current.next;
        }
        return head;
    }

}
