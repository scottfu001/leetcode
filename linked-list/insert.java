/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
   
        if (head == null) {
            Node temp = new Node(insertVal);
            temp.next = temp;
            return temp;
        }
        Node current = head.next;
        Node pre = head;
        boolean moved = false;
        do{
            if(current.val >= insertVal && pre.val <= insertVal){
                pre.next = new Node (insertVal, current);
                return head;
            }
            else if (pre.val > current.val){ //at the edg
                
                if (pre.val <= insertVal || insertVal <= current.val){
                    pre.next = new Node (insertVal, current);
                    return head;
                }
            }
            pre = current;
            current = current.next;
        }while (pre !=  head);
        //back to head
        pre.next = new Node(insertVal, current);
        return head;
    }
}
