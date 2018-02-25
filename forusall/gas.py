# x,y,z is station
wait = [0,0,0]
finalcar = [0,0,0]
for i in cars:
	if x > i and wait[0] == min(wait):
		x = x - i
		wait[0] += i
		finalcar[0] = i
	elif y > i and wait[1] == min(wait):
		y = y - i
		wait[1] += i
		finalcar[1] = i
	elif z > i and wait[2] == min(wait):
		z = z - i
		wait[2] += i
		finalcar[2] = i

res = max(wait[i]-finalcar[i] for i in range(3))
