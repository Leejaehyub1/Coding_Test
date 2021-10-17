import heapq
V, E = map(int, input().split())
start = int(input())

INF = 11 * V
matrix = [[INF] * (V+1) for i in range(V+1)]
for i in range(E):
    u, v, w = map(int, input().split())
    if matrix[u][v] > w:
        matrix[u][v] = w

distance = [INF] * (V+1)
def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for i in matrix[now]:
            print(i)
            cost = dist
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
dijkstra(start)