"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        
        q = deque()
        q.append(node)
        
        visted = {}
        visted[node] = Node(node.val, [])
        
        while q:
            curr = q.popleft()
            #get all neighbors
            for ne in curr.neighbors:
                if ne not in visted:
                    visted[ne] = Node(ne.val, [])
                    q.append(ne)
                visted[curr].neighbors.append(visted[ne])
                                                
        return visted[node]
