class Solution:
    """
    @param s: a string
    @param t: a string
    @return: true if the characters in s can be replaced to get t or false
    """
    def isIsomorphic(self, s, t):
        # write your code here
        dic = {}
        setformap = set()
        for i in range(len(s)):
            if dic.get(s[i]):
                if dic[s[i]] != t[i]:
                    return False
            else:
                if t[i] in setformap:
                    return False
                else:
                    dic[s[i]] = t[i]
                    setformap.add(t[i])
        return True