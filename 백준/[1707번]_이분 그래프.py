from collections import deque

test_num = int(input())
for _ in range(test_num):
    vertex, node = map(int, input().split())
    matrix = [[]for _ in range(vertex+1)]
    visited = [0] * (vertex+1)
    for _ in range(node):
        a, b = map(int, input().split())
        matrix[a].append(b)
        matrix[b].append(a)

    queue = deque()
    num = 1
    flag = True
    for i in range(1, vertex + 1):
        if visited[i] == 0:
            queue.append(i)
            visited[i] = num
            while queue:
                n = queue.popleft()
                for k in matrix[n]:
                    if visited[k] == 0:
                        queue.append(k)
                        visited[k] = -1 * visited[n]

                    elif visited[k] == visited[n]:
                        flag = False

    print('YES' if flag else 'NO')
#visited 1이거나 -1
#n이랑k랑 연결되어있다.
#n이랑k이랑 연결되어 잇는데 visited가 둘아 1이면 =-> 이분그래프가 아니다.