class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []
        

    def push(self, val: int) -> None:
        if self.data:
            current_min = min(val, self.data[-1][0])
            self.data.append((current_min, val))
        else:
            self.data.append((val, val))
        

    def pop(self) -> None:
        self.data.pop()

    def top(self) -> int:
        if self.data:
            return self.data[-1][1]
        return None

    def getMin(self) -> int:
        return self.data[-1][0]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
