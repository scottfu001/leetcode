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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode back = dummy;
        ListNode current = head;
        ListNode front = head.next;
        while (current.next != null){
            current.next = front.next;
            if (back == dummy) {
                front.next = head;
                back = front;
            }
            else{
                front.next = back;
                back = front;
            }
            
            front = current.next;
        }
        return back;
    }
}
