A = [1,2,3]
B = [3,4,5]
C = [6,7,8]
n = 3
bpointer = 0
cpointer = 0
coupleBC=[0 for i in range(n)]
while bpointer < n and cpointer < n:
	if B[bpointer] > C[cpointer]:
		cpointer += 1
		continue
	else:
		coupleBC[bpointer] = n - cpointer
		bpointer +=1
sumcouplcBC = [0 for i in range(n)]
sumcouplcBC[-1] = coupleBC[-1]
for i in range(n-1)[::-1]:
	sumcouplcBC[i] = sumcouplcBC[i+1] + coupleBC[i]

apointer = 0
bpointer = 0
res = 0
while apointer < n and bpointer < n:
	if A[apointer] > B[bpointer]:
		apointer += 1
		continue
	else:
		res += sumcouplcBC[bpointer]
		apointer += 1
print(sumcouplcBC)
print(res)