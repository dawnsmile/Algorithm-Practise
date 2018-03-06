a = 'banana'
# dic = {a[0]:1}
dic = {}
for idx,i in enumerate(a):
	# dic[i] = 1
	if not dic.get(i):
		dic[i] = 1
	else:
		dic[i] += 1
	for j in dic:
		if j < i:
			dic[i] = max(dic[j]+1,dic[i])


	print(dic)

