s = 12435
# print(bin(s))
count = 0
while s != 0:
	if s % 2 == 1:
		count += 1
	s = s / 2

print(count) 