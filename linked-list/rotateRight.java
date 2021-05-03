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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;
        
        //keep the head
        ListNode oldHead = head;
        int length = 0;
        //go to the end and connect the linkedlist as a loop.
        while (oldHead.next != null) {
            oldHead = oldHead.next;
            length++;
        }
        //dont forget the last one
        length++;
        
        //conenct
        oldHead.next = head;
        
        // we need to know how many move we need to do: that is length - (k % length)
        //move the head forward length - (k % length) times, at the same time keep track of prev
        //use dummy for a better start for prev
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0 ; i < length - (k % length) ; i++) {
            prev = prev.next;
            head = head.next;
            
        }
        //break the circle
        prev.next = null;
        return head;
    }
}
