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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;
        //loop the linked list
        while (current.next != null){
            if (current.next.val == val){
                if (current.next.next == null){
                    current.next = null;
                }
                else{
                    current.next = current.next.next;
                }
            }
            else{
                current = current.next;
            }            
        }
        return dummy.next;
    }
}
