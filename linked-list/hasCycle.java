/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode p1 = head;
        ListNode p2 = head;
        while (true){
           //every move p1 move one step, p2 move 2 steps
            if (p1.next != null){
                p1 = p1.next;
            }
            if (p2.next != null){
                if (p2.next.next == null){
                    return false;
                }
                else{
                    p2 = p2.next.next;
                }                
            }
            if (p1.next == null && p2.next == null ) {
                break;
            }
            if (p1.equals(p2)){
                return true;
            }
        }
        return false;
    }
}
