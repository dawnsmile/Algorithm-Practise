# parenthese

s = 'ababaabb'

stackcount = 0
res = False
for i in s:
	if i == 'a':
		stackcount += 1
	else:
		if stack != 0:
			stackcount -= 1
		else:
			break
else:
	if stackcount == 0:
		res = True
