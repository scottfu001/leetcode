class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        length = len(s)
        if length == 0 or length == 1:
            pass
        
        for i in range(length // 2):
            front = s[i]
            back = s[length - 1 - i]
            s[i] = back
            s[length - 1 - i] = front
