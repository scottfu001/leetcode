class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        keys = deque()
        keys.append(0)
        visted = set()
        while keys:
            #get a key
            curr_key = keys.pop()
            if curr_key not in visted:
                #go to that room
                new_keys = rooms[curr_key]
                visted.add(curr_key)
                keys.extend(new_keys)
        
        return len(visted) == len(rooms)
