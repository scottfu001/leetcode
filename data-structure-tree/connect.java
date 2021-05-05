/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    public Node connect(Node root) {
        if (root == null) return null;
        Node leftHead = root;
        while (leftHead != null){//this is the level travel
            //make the head
            Node head = leftHead;
            while (head != null){
                //connec the left to the right,check head has next level
                if (head.left != null) head.left.next = head.right;
                
                //check the next, which was connect from previous call, smae here need to check head has next level
                if (head.next != null){
                    if (head.right != null) head.right.next = head.next.left;
                }
                
                head = head.next;
            }
            //move to the left of the most left
            leftHead = leftHead.left;
        }
        
        return root;
    }
}
