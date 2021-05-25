class Solution:
    
    def helper(self, upper_row, target_index):
        curr_row = []
        curr_row.append(1)
        for i in range(len(upper_row) - 1):
            curr_row.append(upper_row[i] + upper_row[i + 1])            
        curr_row.append(1)
        if target_index == len(upper_row):
            return curr_row
        else:
            return self.helper(curr_row, target_index)
            
        
    
    def getRow(self, rowIndex: int) -> List[int]:
        if rowIndex == 0:
            return [1]
        if rowIndex == 1:
            return [1] * 2
        
        curr = [1]
        return self.helper(curr, rowIndex)
