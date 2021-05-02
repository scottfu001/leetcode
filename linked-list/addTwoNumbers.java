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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean forwardOne = false;
        ListNode lp1 = l1;
        ListNode lp2 = l2;
        //new list, dont want to touch the original lists
        ListNode head = null;
        ListNode current = null;
        while (lp1 != null || lp2 != null){
            ListNode sum = null;
            int val = 0;
            if (lp1 != null && lp2 == null){
                if (forwardOne) {
                    val = lp1.val + 1;
                }
                else{
                    val = lp1.val;
                }
            }
            else if (lp1 != null && lp2 != null){
                if (forwardOne) {
                    val = lp1.val + lp2.val + 1;
                }
                else{
                    val = lp1.val + lp2.val;
                }
            }
            else if (lp1 == null && lp2 != null){
                if (forwardOne) {
                    val = lp2.val + 1;
                }
                else{
                    val = lp2.val;
                }
            }
            
            if (val >= 10){
                forwardOne = true;
                val = val - 10;
            }
            else{
                forwardOne = false;
            }
            
            //check new list
            if (head == null){
                head = new ListNode(val);
                current = head;
            }
            else{
                current.next = new ListNode(val);
                current = current.next;
            }
            
            if (lp1 != null) lp1 = lp1.next;
            if (lp2 != null) lp2 = lp2.next;
        }
        
        //final check if all end but still have a forward one
        if (forwardOne){
            current.next = new ListNode(1);
            current = current.next;
        }
        
        return head;
    }
}
