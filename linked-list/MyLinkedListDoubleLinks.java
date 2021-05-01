public class MyLinkedListNode {
    int val;
    MyLinkedListNode next;
    MyLinkedListNode prev;    
    public MyLinkedListNode(int val){
        this.val = val;
    }
}

class MyLinkedList {

    int size = 0;
    MyLinkedListNode head;
    
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        MyLinkedListNode current = head;
        for (int i = 0; i < index && current != null; i++){ // end at the index
            current = current.next;
        } 
        return current.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null){
            head = new MyLinkedListNode(val);
            size++;
            return;
        }
        MyLinkedListNode cur = new MyLinkedListNode(val);
        cur.next = head;
        head.prev = cur;
        head = cur;
        size++;
        return;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null){
            this.addAtHead(val);
            return;
        }
        MyLinkedListNode current = head;
        while (current.next != null){
            current = current.next;
        }
        MyLinkedListNode newNode = new MyLinkedListNode(val);
        current.next = newNode;
        newNode.prev = current;
        size++;
        return;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        //add to the head 
        if (index == 0){
            this.addAtHead(val);
            return;
        }
        
        MyLinkedListNode pre = head;        
        for(int i = 0; i < index -1;  ++i){            
            pre = pre.next;
        }
        MyLinkedListNode newNode = new MyLinkedListNode(val); 
        MyLinkedListNode nextNode = pre.next; 
        newNode.next = nextNode;
        if (nextNode != null) nextNode.prev = newNode;
        pre.next = newNode;
        newNode.prev = pre;
        size++;
        return;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        if (index == 0){
            head = head.next;
            if (head != null){
                head.prev = null;
            }
            return;
        }
        MyLinkedListNode pre = head;
        for(int i = 0; i < index - 1;  i++){
            pre = pre.next;
        }
        if( pre.next.next == null){
            pre.next.prev = null;
            pre.next = null;
        }
        else {
            MyLinkedListNode temp = pre.next;
            pre.next = pre.next.next;
            pre.next.prev = pre;
            temp.next = null;
            temp.prev = null;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
