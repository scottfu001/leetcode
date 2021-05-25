class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return s
        #put chars to a queue
        digi = set([str(x) for x in range(10)])
        q = deque()
        for cha in s:                        
            if cha == ']':
                #we need to process
                str_temp = deque()
                curr_char = q.pop() #one from the q
                while curr_char != '[': #get the inner str
                    str_temp.appendleft(curr_char)
                    curr_char = q.pop()
                    
                #get the int
                num_temp = deque()
                while q and q[-1] in digi:
                    curr_num = q.pop()
                    num_temp.appendleft(curr_num)
                    
                p_int = int(''.join(num_temp))
                
                #do the processing
                p_str = ''.join(str_temp) * int(p_int)
                #put the str back to the q
                for p_cha in p_str:
                    q.append(p_cha)
            else:
                q.append(cha)
                
        return ''.join(q)
