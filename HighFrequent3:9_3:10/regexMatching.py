class Solution:
    """
    @param s: A string 
    @param p: A string includes "." and "*"
    @return: is Match?
    """
    def isMatch(self, s, p):
        # write your code here
        pp = []
        if p[0] == '*':
            return False
        for i in p:
            if i == '*':
                pp[-1] = pp[-1] + '*'
            else:
                pp.append(i)
        
        dp = [[False for i in range(len(pp)+1)] for j in range(len(s)+1)]
        dp[0][0] = True
        for idx,i in enumerate(pp):
            if '*' in i and dp[0][idx]:
                dp[0][idx+1] = True
        for idx,i in enumerate(s):
            for jdx,j in enumerate(pp):
                # print(dp)
                # if idx == 0 and jdx == 0:
                #     dp[idx][jdx] = True
                #     continue
                # if idx == 0:
                #     if ('*' in j ) and dp[idx][jdx-1]:
                #         dp[idx][jdx] = True
                #     if (j == i or j == '.' or '*' in j) and set(p[:jdx]) == set('*'):
                #         dp[idx][jdx] = True
                #     continue
                # # print(dp)
                # if jdx == 0:
                #     if j == '.*':
                #         dp[idx][jdx] = True
                #     continue
                if dp[idx][jdx] and (i == j or j == '.*' or j == '.' or j == i+'*'):
                    dp[idx+1][jdx+1] = True
                if '*' in j and (dp[idx+1][jdx]):
                    dp[idx+1][jdx+1] = True
                if (j == i+'*' or j == '.*') and (dp[idx][jdx+1]):
                    dp[idx+1][jdx+1] = True
                
        # print(dp)
        return dp[-1][-1]

a = Solution()
print(a.isMatch('bbabacccbcbbcaaab','*a*b..b*b'))