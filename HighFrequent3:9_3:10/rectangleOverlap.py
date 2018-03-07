class Solution:
    """
    @param l1,r1,l2,r2: a point contains x and y
    @return: true if overlap
    """
    def isOverlap(self, l1, r1, l2, r2):
        if (l1.x < r2.x) or (l2.x < r1.x):
            return False
        if (r1.y > l2.y) or (r2.y > l1.y):
            return False
        return True