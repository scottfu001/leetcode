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
    // copy from previous solution
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
    
    public boolean checkPalindrome(ListNode head, ListNode secondHalfHead){
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }        
        return result;
    }
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next != null && head.next.next == null ){
            return head.val == head.next.val ? true : false;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode faster = dummy;
        ListNode slow = dummy;
        while (faster != null){
            if (faster.next == null){
                break;
            }
            else if (faster.next.next == null){
                //we move the faster to the end of the list and move slow one more step forward
                faster = faster.next;
                slow = slow.next;
                break;
            }       
            slow = slow.next;
            faster = faster.next.next;
        }
        
        //reverse the second half
        ListNode reverseHaed = this.reverseList(slow.next);
        //compare, if the first half has one more than the second half,  we dont need to care.
        return this.checkPalindrome(head, reverseHaed);
        
    }
}
