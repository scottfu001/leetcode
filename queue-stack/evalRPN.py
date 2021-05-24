class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        q = []
        ops = {'+', '-', '*', '/'}
        result = tokens[0]
        for tok in tokens:
            if tok in ops:                
                right = int(q.pop())
                left = int(q.pop())
                if tok == '+':
                    result = left + right
                elif tok == '-':
                    result = left - right
                elif tok == '*':
                    result = left * right
                else:
                    result = int(left / right)
                print(result)
                q.append(str(result))                    
            else:
                q.append(tok)
        return result
