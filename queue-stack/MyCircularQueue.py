class MyCircularQueue:
    

    def __init__(self, k: int):
        self.q = [] # the data
        self.k = k # the max size

    def enQueue(self, value: int) -> bool:
        # check the queue is full
        if self.isFull():
            return False
        else:
            self.q.append(value)
            return True

    def deQueue(self) -> bool:
        #get the first one
        if self.isEmpty():
            return False
        else:
            del self.q[0]
            return True

    def Front(self) -> int:
        if self.isEmpty():
            return -1
        else:
            return self.q[0]

    def Rear(self) -> int:
        if self.isEmpty():
            return -1
        else:
            return self.q[-1]
        

    def isEmpty(self) -> bool:
        if len(self.q) == 0:
            return True
        else:
            return False
        

    def isFull(self) -> bool:
        if len(self.q) >= self.k:
            return True
        else:
            return False


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear(
