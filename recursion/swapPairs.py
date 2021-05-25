# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head and head.next:
            #do the swap
            first = head
            second = head.next           
            if second.next:
                first.next = second.next
            else:
                first.next = None
            second.next = first
            head = second
            first.next = self.swapPairs(first.next)
                
        else:
            return head
        return head

     def swapPairs(self, head: ListNode) -> ListNode:
        temp = ListNode(-1)
        temp.next = head
        
        pre = temp
        while head and head.next:
            first = head
            second = head.next
            pre.next = second # connect the pre pair to this pair
            first.next = second.next
            second.next = first
            
            
            pre = first
            head = first.next
        return temp.next
