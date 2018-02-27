# movie = [6,1,3,6,3,2,7,4]
# time comlexity:O(n)
# two non-overlapping subarray, length = k, l

sumlist=[movie[0]]
for i in movie[1:]:
	sumlist.append(sumlist[-1]+i) 

# first pass, k subarray in front of l
maxl=sumlist[-1]-sumlist[-1-l]
maxk=sumlist[-1-l]-sumlist[-1-l-k]
for i in range(len(movie)-l-k)[::-1]:

	maxl = max(maxl,sumlist[i+k+l]-sumlist[i+k])
	maxk = max(maxl,sumlist[i+k]-sumlist[i])


res = maxk + maxl

# second pass, l in front of k

maxk=sumlist[-1]-sumlist[-1-k]
maxl=sumlist[-1-k]-sumlist[-1-l-k]
for i in range(len(movie)-l-k)[::-1]:

	maxl = max(maxl,sumlist[i]-sumlist[i+l])
	maxk = max(maxl,sumlist[i+k+l]-sumlist[i+l])


res = max(res,maxk + maxl)

