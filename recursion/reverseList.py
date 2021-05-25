class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        pre = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return pre
      
     def reverseList(self, head: ListNode) -> ListNode:        
        pre = None
        curr = head
        while curr:
            tmp = curr.next
            curr.next = pre
            pre = curr
            curr = tmp
        return pre
