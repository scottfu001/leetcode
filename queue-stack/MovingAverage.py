class MovingAverage:

    def __init__(self, size: int):
        """
        Initialize your data structure here.
        """
        self.q = []
        self.size = size
        

    def next(self, val: int) -> float:
        # check if the queue is full
        if len(self.q) >= self.size:
            #remove the first one and put the new one in
            del self.q[0]
            self.q.append(val)
        else:
            self.q.append(val)
        tatal = sum(self.q)
        length = len(self.q)
        return tatal / length
        


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)
