class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        size = len(temperatures)
        q, result = [], [0] * size
        for index in range(size):
            #loop the q, to check is any index is not processed
            while q and temperatures[q[-1]] < temperatures[index]:
                result[q[-1]] = index - q[-1]
                q.pop()                    
            q.append(index)
        return result
