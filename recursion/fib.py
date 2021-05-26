class Solution:
    
    def helper(self, n):
        if n in self.result:
            return self.result[n]
        if n >=2 :
            print(n)
            curr = self.helper(n - 1) + self.helper(n - 2)
            self.result[n] = curr
            return curr
    
    def fib(self, n: int) -> int:
        self.result  = {}
        self.result[0] = 0
        self.result[1] = 1
        self.helper(n)      
        return self.result[n]
