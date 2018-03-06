dic = {}
for i in array:
	if dic.get(i % k):
		dic[i%k].append(i)
	else:
		dic[i%k] = [i]