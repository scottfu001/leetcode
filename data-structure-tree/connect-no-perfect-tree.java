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
        //need to do level travel
        Queue<Node> nodes = new LinkedList<>(); //these are leveling nodes
        nodes.add(root);
        while(!nodes.isEmpty()){
            //need to loop the current nodes and add new nodes to the queue
            int size = nodes.size(); //need a valiable to hold the size, the queue is changing
            for (int i = 0 ; i < size; i ++){
                Node current = nodes.poll();
                //if the queue is not empty, we connec the cuurent to the next
                if (i < size - 1){ //check to the last node, can't us empty to check, we are adding node to the queue.
                    current.next = nodes.peek(); //this will be process next
                }
                //put the 
                if (current.left != null) {
                   nodes.add(current.left);
                }
                if (current.right != null) {
                   nodes.add(current.right);
                }
            }
            

        }
        
        return root;        
    }
}
