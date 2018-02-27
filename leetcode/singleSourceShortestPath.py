import Queue
class Solution(object):
    def networkDelayTime(self, times, N, K):
        """
        :type times: List[List[int]]
        :type N: int
        :type K: int
        :rtype: int
        """
        
        q = Queue.Queue()
        q.put(K)
        weight = {}
        for i in times:
            if weight.get(i[0]):
                weight[i[0]].append((i[1],i[2]))
            else:
                weight[i[0]] = [(i[1],i[2])]
        d = [float('inf') for i in range(N+1)]
        d[0] = 0
        d[K] = 0
        while not q.empty():
            u = q.get()
            for i in weight.get(u,[]):
            
                if d[i[0]] > d[u] + i[1]:
                    d[i[0]] = d[u] + i[1]
                    q.put(i[0])
        if max(d) == float('inf'):
            return -1
        return max(d)