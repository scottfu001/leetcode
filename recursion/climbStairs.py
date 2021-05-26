class Solution:
    
    def helper(self, n):
        if n in self.result:
            return self.result[n]
        steps = self.helper(n - 1) + self.helper(n - 2)
        self.result[n] = steps
        return steps
    
    def climbStairs(self, n: int) -> int:
        self.result = {}
        self.result[1] = 1
        self.result[2] = 2
        self.helper(n)
        return self.result[n]
