a = '2354635543543436546'
a = list(a)
awithi = [(i,idx) for idx,i in enumerate(a)]

b = sorted(awithi)
pointer = 1
res = 0
while pointer < len(b):
	temp = 	pointer - 1 
	res = max(res, abs(b[temp][1] - b[pointer][1]))
	pointer += 1
	while pointer < len(b) and b[pointer][0] == b[pointer-1][0]:
		res = max(res, abs(b[temp][1] - b[pointer][1]))
		pointer += 1
	# res = max(res,abs(b[temp][1] - b[pointer][1]), abs(b[temp + 1][1] - b[temp][1]), abs(b[temp + 1][1] - b[pointer][1]))
	


print(res)


