/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> aSet = new HashSet<>();
        ListNode pa = headA;
        do{
            aSet.add(pa);
            pa = pa.next;
        }while (pa != null);
        
        //loop the B and check
        ListNode pb = headB;
        do{
            if (aSet.contains(pb)){
                return pb;
            }
            pb = pb.next;
        }while (pb != null);
        
        return null;
    }
}
