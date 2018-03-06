# O(n)?

s = [1,2,3,4,4,5,5,6]
count = {}
for i in s:
	count[i] = count.get(i,0) + 1
res = 0
for i in sorted(count.keys()):
	res += i
	temp = 1
	count[i] -= 1
	while not count.get(i+temp) and count[i] > 0:
		res += i+temp
		count[i] -= 1
		temp += 1
	if count[i] == 0:
		continue
	else:
		count[i+temp] += count[i]

print(res)
	