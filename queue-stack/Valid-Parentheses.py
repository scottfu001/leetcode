class Solution:
    def isValid(self, s: str) -> bool:
        
        if (len(s) % 2) != 0:
            return False
        
        q = []
        for brac in s:
            if brac == ')':
                if q and q[-1] == '(':
                    q.pop()
                else:
                    return False
            elif brac == '}':
                if q and q[-1] == '{':
                    q.pop() 
                else:
                    return False
            elif brac == ']':
                if q and q[-1] == '[':
                    q.pop()
                else:
                    return False
            else:
                q.append(brac)
        if q:
            return False
        else:
            return True
