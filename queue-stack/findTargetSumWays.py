class Solution:
     
    def findTargetSumWays(self, nums: List[int], target: int) -> int: 
        max_sum = sum(nums) # get the max total from the list
        # the target can be -max_sum to max_sum

        if target > max_sum or target < -max_sum:
            return 0
        
         #the map to hold tha value
        dp = [[0] * (max_sum * 2 + 1) for _ in range(len(nums) + 1)]
        #set the base cases
        dp[0][0 + max_sum] = 1 
        for i in range(1, len(nums) + 1):
            for j in range(-max_sum , max_sum + 1):
                if j - nums[i - 1] + max_sum >= 0: 
                    dp[i][j - nums[i - 1] + max_sum] += dp[i - 1][j + max_sum]
                if j + nums[i - 1] + max_sum <= 2 * max_sum:
                    dp[i][j + nums[i - 1] + max_sum] += dp[i - 1][j + max_sum]
        return dp[len(nums)][target + max_sum]
        
