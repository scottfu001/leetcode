class Solution {
    
    /*this question has two problems
    1: can a node has two links to the same node? random and next pointers
    2: can two nodes has the same values?
    */
    Map<Node, Node> nodeToVistedNodeMap = new HashMap<Node, Node>();
        
    public Node getVistedNode(Node current){
        if (current == null) return null;
        if (nodeToVistedNodeMap.containsKey(current)){
            return this.nodeToVistedNodeMap.get(current);
        }
        else{
            //return a new node
            this.nodeToVistedNodeMap.put(current, new Node(current.val, null, null));
            return this.nodeToVistedNodeMap.get(current);
        }
    }
    
    public Node copyRandomList(Node head) {

        if (head == null) return null; 
        //need a data structure to keep records of visted node
        
        //make a new head
        Node oldCurrent = head;
        Node newCurrent = new Node(oldCurrent.val);
        this.nodeToVistedNodeMap.put(oldCurrent, newCurrent);
        //loop the old linked list
        while (oldCurrent != null){
            //get the address of visited node to link, if visted  befroe, will return  old node, otherwise, new node.
            newCurrent.random = this.getVistedNode(oldCurrent.random);
            newCurrent.next = this.getVistedNode(oldCurrent.next);
            
            //move forward
            newCurrent = newCurrent.next;
            oldCurrent = oldCurrent.next;
        }
        
        return this.nodeToVistedNodeMap.get(head);
    }
}
