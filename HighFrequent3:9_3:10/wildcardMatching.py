class Solution:
    """
    @param s: A string 
    @param p: A string includes "?" and "*"
    @return: is Match?
    """
    def isMatch(self, s, p):
        # write your code here
        if s == '':
            if set(p) == set('*'):
                return True
            else:
                return False
        dp = [[False for i in range(len(p))] for j in range(len(s))]
        for idx,i in enumerate(s):
            for jdx,j in enumerate(p):
                # print(dp)
                if idx == 0 and jdx == 0:
                    if i != j and j != '?' and j != '*':
                        return False
                    else:
                        dp[idx][jdx] = True
                        continue
                
                if idx == 0:
                    if (j == '*') and dp[idx][jdx-1]:
                        dp[idx][jdx] = True
                    if (j == i or j == '?') and set(p[:jdx]) == set('*'):
                        dp[idx][jdx] = True
                    continue
                # print(dp)
                if jdx == 0:
                    if j == '*':
                        dp[idx][jdx] = True
                    continue
                if dp[idx-1][jdx-1] and (i == j or j == '*' or j == '?'):
                    dp[idx][jdx] = True
                if j == '*' and (dp[idx][jdx-1] or dp[idx-1][jdx]):
                    dp[idx][jdx] = True
        # print(dp)
        return dp[-1][-1]


a = Solution()
print(a.isMatch('abc','????'))