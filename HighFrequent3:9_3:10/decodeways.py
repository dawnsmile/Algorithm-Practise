# A message containing letters from A-Z is being encoded to numbers using the following mapping:

# 'A' -> 1
# 'B' -> 2
# ...
# 'Z' -> 26
# Given an encoded message containing digits, determine the total number of ways to decode it.

# For example,
# Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

# The number of ways decoding "12" is 2.

class Solution:
    """
    @param s: a string,  encoded message
    @return: an integer, the number of ways decoding
    """
    def numDecodings(self, s):
        # write your code here
        if len(s) == 0 or s == '0':
            return 0
        if len(s) == 1:
            return 1
        curways = 1
        formerways = 1
        for idx,element in enumerate(s):
            if idx == 0:
                continue
            if int(s[idx-1:idx+1]) == 0:
                return 0
            if int(s[idx-1:idx+1]) > 26 and element == '0':
                return 0

            if int(s[idx-1:idx+1]) <= 26 and int(s[idx-1:idx+1]) >= 10:
                if element != '0':
                
                    tmp = formerways + curways
                else:
                    tmp = formerways
            else:
                tmp = curways

            
            formerways = curways
            curways = tmp

        return curways
