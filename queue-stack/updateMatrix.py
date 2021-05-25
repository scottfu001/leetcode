class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        around = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        mat = mat
        rows = len(mat)
        cols = len(mat[0])
        # replace 1 to rows + cols
        result = [[rows + cols] * cols for _ in range(rows)]
        q = []
        zeros = set()
        #put all 0 to q
        for x in range(rows):
            for y in range(cols):
                if mat[x][y] == 0:
                    result[x][y] = 0
                    q.append((x, y))
                    zeros.add((x, y))
        
        #process the q
        while q:
            curr = q.pop()
            #check the neighbors
            curr_dist = result[curr[0]][curr[1]]
            for i, j in around:
                new_x = curr[0] + i
                new_y = curr[1] + j
                if 0 <= new_x < rows and 0<= new_y < cols and (new_x, new_y) not in zeros:
                    if result[new_x][new_y] > curr_dist + 1:
                        result[new_x][new_y] =  curr_dist + 1
                        q.append((new_x, new_y))
                
        return result
  
  #2 
      def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        around = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        rows , cols = len(mat), len(mat[0])
        for x in range(rows):
            for y in range(cols):
                if mat[x][y]:
                    # cehck the op and left
                        top = mat[x - 1][y] if x > 0 else rows + cols
                        left = mat[x][y - 1] if y > 0 else rows + cols
                        mat[x][y] = min(top , left) + 1
                        
        for x in range(rows - 1, - 1, -1):
            for y in range(cols - 1, -1, -1):
                if mat[x][y]:
                    # cehck the op and left
                        bottom = mat[x + 1][y] if x < rows - 1 else rows + cols
                        right = mat[x][y + 1] if y < cols - 1 else rows + cols
                        mat[x][y] = min(mat[x][y], bottom + 1, right + 1)
        
        return mat
