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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        Set<ListNode> touchedNodeSet = new HashSet<>();
        ListNode current = head;
        while (current.next != null){
            //put to the set
            if (touchedNodeSet.contains(current)){
                return current;
            }
            else{
                touchedNodeSet.add(current);
            }
            current = current.next;
        }
        return null;
    }
}
