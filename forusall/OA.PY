s=[1,0,9,0,10,0]

needtodelete=[0]*26
char=set(s)
res=len(s)
appear=set()
for idx,i in enumerate(s):
	# char.add(i)
	# needtodelete[i]=idx
	# print(needtodelete)

	# for j in range(0,i):
	# 	needtodelete[j]+=1
	if needtodelete[i] == 0:
		needtodelete[i]=idx
	for j in char:
		if j < i:
			needtodelete[i]=min(needtodelete[i],needtodelete[j])
	appear.add(i)
	for j in char:
		if (j > i and j in appear) or j<i:
			needtodelete[j]+=1

	print(i,needtodelete)

for i in range(26):
	if i in char:
		res=min(res,needtodelete[i])
print(res,needtodelete,char)
	