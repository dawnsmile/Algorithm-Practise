from collections import deque
map = [['1','1','1','0','a'], ['1','0','1','A','1'], ['1','b','0','0','1'], ['B','0','3','0','2'], ['1','1','1','0','0']]
n = len(map)
m = len(map[0])
for i in range(n):
    for j in range(m):
        if map[i][j] == '2':
            start = (i,j)

q = deque( [(start[0],start[1],0,'')])
# start_x start_y steps keybag visited

# ne = []
visited = set()
while q :
    
    temp = q.popleft()
    # print(temp,q,visited)
    
    # tempset = set()
    
    if map[temp[0]][temp[1]] == '3':
        print(temp[2])
        exit()
    # if door, without keys, stop this way 
    if map[temp[0]][temp[1]] >= 'A' and map[temp[0]][temp[1]] <= 'Z':
        if map[temp[0]][temp[1]].lower() not in temp[3]:
            # door is the last in the queue
            # if q == []:
            #     q = ne
            #     ne = []
            continue
        # else:
        #     visited = set()
    tempkey = temp[3]
    
    
    # tempvisited = temp[4]
    if map[temp[0]][temp[1]] >= 'a' and map[temp[0]][temp[1]] <= 'z':
        if map[temp[0]][temp[1]] not in temp[3]:
            # tempset.add(map[temp[0]][temp[1]])
            tempkey = ''.join(sorted(tempkey+map[temp[0]][temp[1]]))
            # meet key, reset visited
    # visited = set([(temp[0],temp[1],tempkey)])
    visited.add((temp[0],temp[1],tempkey))

    for i,j in [(-1,0),(1,0),(0,-1),(0,1)]:
        if temp[0]+i>=0 and temp[0]+i < n and temp[1]+j>=0 and temp[1]+j < m and map[temp[0]+i][temp[1]+j] != '0' and (temp[0]+i,temp[1]+j,tempkey) not in visited:
            q.append((temp[0]+i,temp[1]+j,temp[2]+1,tempkey))


    # if q == []:
    #     q = ne
    #     ne = []