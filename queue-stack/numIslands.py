class Solution:
  #DFS
    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        around = [(0, 1), (0, -1), (1, 0), (-1, 0)] 
        visted = []
        
        def sink(x, y):
            for (xp, yp) in around:
                new_x = x + xp
                new_y = y + yp
                if 0 <= new_x < rows and 0 <= new_y < cols and (new_x, new_y) not in visted and grid[new_x][new_y] == "1":
                    grid[new_x][new_y] = 0
                    sink(new_x, new_y)
                      
        for x in range(rows):
            for y in range(cols):
                if grid[x][y] == "1":
                    visted.append((x, y))
                    sink(x, y)

        return len(visted)
   
#BFS
    
    def numIslands2(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        around = [(0, 1), (0, -1), (1, 0), (-1, 0)] 
        visted = []
        result = 0
                    
        def sinkBFS(x, y):
            q= []
            q.append((x, y))
            while q:
                i = q[0][0]
                j = q[0][1]
                del q[0]
                for (xp, yp) in around:
                    new_x = i + xp
                    new_y = j + yp
                    if 0 <= new_x < rows and 0 <= new_y < cols and (new_x, new_y) not in visted and grid[new_x][new_y] == "1":
                        grid[new_x][new_y] = 0
                        visted.append((new_x, new_y))
                        q.append((new_x, new_y))
        
                      
        for x in range(rows):
            for y in range(cols):
                if grid[x][y] == "1":
                    sinkBFS(x, y)
                    result += 1

        return result
