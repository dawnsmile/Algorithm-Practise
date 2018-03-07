class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        def binary(minlast,num):
            start = 0
            end = len(minlast) - 1
            while start + 1 < end:
                mid = int((start + end) / 2)
                if minlast[mid] < num:
                    start = mid
                else:
                    end = mid
            return end
        minlast = [float('-inf')] + n * [float('inf')]
        for idx, i in enumerate(nums):
            index = binary(minlast,i)
            minlast[index] = i

        for idx, i in enumerate(minlast[::-1]):
            if i != float('inf'):
                return idx
        return 0
        