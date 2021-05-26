class Solution:
    
    def helper(self, x, n):
        if n == 0:
            return 1.0
        if n == 1:
            return x
        
        curr = self.helper( x , n // 2 )
        if n % 2 == 1:
            
            return curr * curr * x
        else:
            return curr * curr
    
    def myPow(self, x: float, n: int) -> float:        
        if n < 0:
            x = 1 /  x
            n = -n
            
        return self.helper(x, n)
      
   #2
  
      def myPow(self, x: float, n: int) -> float:        
        if n < 0:
            x = 1 /  x
            n = -n
            
        
        
        ''' 
        the template is 
        temp_count = n just n 
        ans = ??? the result to return
        temp_re = ??? temp result to store value from pre steps
         while temp_count:   loop untill to 0
            if temp_count % 2 == 1: chekc if we need to times more
            ???????????????
            temp_count = temp_count // 2 reduce temp_count
            
        return ans

        '''        
        
        temp_count = n
        ans = 1 # when n == 0  we know we need to have 1 return, so this is one
        temp_re = x # when n == 1, we need to return x , we will know this shoule be x
        while temp_count:
            if temp_count % 2 == 1:
                ans = temp_re * ans # this is the case when n == 1, we have the ans, but need to time something.
            temp_re = temp_re * temp_re
            temp_count = temp_count // 2
            
        return ans
