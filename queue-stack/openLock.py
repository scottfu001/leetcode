class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        count = 0
        q = ['0000']
        #use set to check, much fster than list, we dont repeat the visted values
        visted = {'0000'}        
        dead = set(deadends)
        while q:
            next_q = []
            for curr in q:
                if curr in dead:
                    continue

                if curr == target:
                    return count

                for i in range(4):
                    curr_num = int(curr[i])
                    for j in (-1, 1):
                        new_num = (curr_num + j) % 10
                        neighbor = curr[:i] + str(new_num) + curr[i+1:]
                        if neighbor not in visted:
                            visted.add(neighbor)
                            next_q.append(neighbor)
            q = next_q
            count += 1            
        return -1
                    
