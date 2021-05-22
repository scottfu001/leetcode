class Solution:
   
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        # get all door
        rows = len(rooms)
        cols = len(rooms[0])
        grip = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        checks = [(i , j ) for i in range(rows) for j in range(cols) if rooms[i][j] == 0]
        
        for x, y in checks:
            for xp, yp in grip:
                new_x, new_y = x + xp, y + yp
                if 0 <= new_x < rows and 0 <= new_y < cols and rooms[new_x][new_y] == 2147483647:
                    rooms[new_x][new_y] = rooms[x][y] + 1
                    # put back to checks for later
                    checks.append((new_x, new_y))
