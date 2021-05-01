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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null || (head.next != null && head.next.next == null)) return head;
        ListNode currentOdd = head;
        ListNode currentEven = head.next;
        ListNode current = head.next.next;
        int oddEven = 1;
        while (current != null) {
            ListNode temp = current;
            current = current.next;
            if (oddEven % 2 == 1){
               currentEven.next = temp.next;
               temp.next = currentOdd.next;
               currentOdd.next = temp;
               currentEven = currentEven.next;
               currentOdd = currentOdd.next; 
            }            
            oddEven++;
        }
        return head;
    }
}
