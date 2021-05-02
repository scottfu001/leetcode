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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode tail = null;
        ListNode lp1 = l1;
        ListNode lp2 = l2;
        while (lp1 != null || lp2 != null){
            ListNode nextTarget = null;
            if (lp1 != null && lp2 == null){
                nextTarget = lp1;
                lp1 = lp1.next;
            }
            else if (lp1 != null && lp2 != null){
                if (lp1.val > lp2.val) {
                    nextTarget = lp2;
                    lp2 = lp2.next;
                }
                else{
                    nextTarget = lp1;
                    lp1 = lp1.next;
                }
            }
            else if (lp1 == null && lp2 != null){
                nextTarget = lp2;
                lp2 = lp2.next;
            }
            
            if (newHead == null){
                newHead = nextTarget;
                tail = newHead;
            }
            else{
                tail.next = nextTarget;
                tail = tail.next;
            }
        }
        return newHead;
    }
}
