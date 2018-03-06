# ip validation
# LC 468
s = "20EE:FGb8:85a3:0:0:8A2E:0370:7334"

def ipv4checker(s):
	temp = s.split('.')
	if len(temp) != 4:
		return False
	for i in temp:
		# print(i[0])
		if not i.isdigit():
			return False
		if int(i) > 255:
			return False
		if i[0] == '0' and (int(i)!= 0 or len(i)!=1):
			
			return False
	return True

def ipv6checker(s):
	temp = s.split(':')
	if len(temp) != 8:
		return False
	for i in temp:
		if len(i) > 4 or len(i) == 0:
			return False
		if not i.isalnum():
			return False
		try:
			int(i,16)
		except ValueError:
			return False
	return True
if '.' in s:
	if ipv4checker(s):
		print('IPV4')
		exit()
if ':' in s:
	if ipv6checker(s):
		print('IPV6')
		exit()

print('neither')	
