"""
Definition for a point.
class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b
"""
import heapq

class Solution:
    """
    @param: points: a list of points
    @param: origin: a point
    @param: k: An integer
    @return: the k closest points
    """
    def kClosest(self, points, origin, k):
        # write your code here
        maxheap = []
        for i in points:
            if len(maxheap) < k:
                heapq.heappush(maxheap,(0 - self.distance(i,origin),i.x,i.y))
            else:
                temp = heapq.heappop(maxheap)
                if temp[0] == 0 - self.distance(i,origin):
                    if temp[1] > i.x:
                        heapq.heappush(maxheap,(temp[0],i.x,i.y))
                        continue
                    if temp[1] == i.x and temp[2] > i.y:
                        heapq.heappush(maxheap,(temp[0],i.x,i.y))
                        continue
                if temp[0] > 0 - self.distance(i,origin):
                    heapq.heappush(maxheap,(0 - self.distance(i,origin),i.x,i.y))
                    continue
                heapq.heappush(maxheap,temp)
        return maxheap

    def distance(self, a, b):
        return (a.x - b.x)**2 + (a.y - b.y)**2