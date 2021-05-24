class Solution(object):
    def numSquares(self, n):
        # find the max perfect square 
        sq = [i**2 for i in range(0, int(math.sqrt(n))+1)]
        results = [float('inf')] * ( n + 1) #we need one more for 0
        results[0] = 0
        
        for i in range(1, n + 1):
            for s in sq:
                if i < s:
                    break
                results[i] = min(results[i - s] + 1, results[i])
        return results[-1]
