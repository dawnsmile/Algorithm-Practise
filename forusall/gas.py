# x,y,z is station
x,y,z=7,11,3
cars=[2,8,4,3,2]
wait = [0,0,0]
finalcar = [0,0,0]



for i in cars:
	candidate=[]
	if x >= i:
		candidate.append(wait[0])
	if y >= i:
		candidate.append(wait[1])
	if z >= i:
		candidate.append(wait[2])
	if x >= i and wait[0] == min(candidate) :
		x = x - i
		wait[0] += i
		finalcar[0] = i
	elif y >= i and wait[1] == min(candidate):
		y = y - i
		wait[1] += i
		finalcar[1] = i
	elif z >= i and wait[2] == min(candidate):
		z = z - i
		wait[2] += i
		finalcar[2] = i

res = max(wait[i]-finalcar[i] for i in range(3))

print x,y,z,wait