class Solution:
    """
    @param s: A string 
    @param p: A string includes "." and "*"
    @return: is Match?
    """
    def isMatch(self, s, p):
        # write your code here
        pp = []
        for i in p:
            if i == '*':
                pp[-1] = pp[-1] + '*'
            else:
                pp.append(i)
        
        dp = [[False for i in range(len(pp))] for j in range(len(s))]
        for idx,i in enumerate(s):
            for jdx,j in enumerate(pp):
                # print(dp)
                if idx == 0 and jdx == 0:
                    if i == j or j == '.' or j == '.*' or j == i+'*':
                        dp[idx][jdx] = True
                        continue
                    else:
                        return False
                
                if idx == 0:
                    if ('*' in j) and dp[idx][jdx-1]:
                        dp[idx][jdx] = True
                    if (j == i or j == '.' or '*' in j) and set(p[:jdx]) == set('*'):
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
