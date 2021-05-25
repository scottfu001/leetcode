class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        self.image = image
        self.around = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        self.rows = len(image)
        self.cols = len(image[0])
        self.color = self.image[sr][sc]
        self.new_color = newColor
        self.visted = set()
        self.dfs(sr, sc)        
        return self.image
        
        
    def dfs(self, x, y):
        if self.image[x][y] == self.color:
            self.visted.add((x, y))
            self.image[x][y] =  self.new_color
        #check around
        for i, j in self.around:
            new_x = x + i
            new_y = y + j
            if (new_x, new_y) not in self.visted and 0 <= new_x < self.rows and 0 <= new_y < self.cols and self.image[new_x][new_y] == self.color:
                self.dfs(new_x, new_y)
