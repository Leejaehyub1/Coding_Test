from collections import deque


def solution(n, edge):
    answer = 0
    route = [-1] * (n + 1)
    graph = [[] for i in range(n + 1)]
    queue = deque()

    for e in edge:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])

    queue.append(1)
    route[1] = 0

    while queue:
        now = queue.popleft()
        for g in graph[now]:
            if route[g] == -1:
                queue.append(g)
                route[g] = route[now] + 1

    print(route)
    return route.count(max(route))