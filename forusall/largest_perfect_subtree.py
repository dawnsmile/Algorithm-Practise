res = 0
def dfs(node):
	if node is None:
		return 0
	leftsize = dfs(node.left)
	rightsize = dfs(node.right)
	res = max(res,min(leftsize,rightsize)*2+1)
	return min(leftsize,rightsize)*2+1
