from collections import deque


def solution(N, road, K):
    answer = 0
    nodes = {}

    graph = {i: float('inf') for i in range(1, N + 1)}
    graph[1] = 0

    for v1, v2, d in road:
        nodes[v1] = nodes.get(v1, []) + [(v2, d)]
        nodes[v2] = nodes.get(v2, []) + [(v1, d)]

    que = deque([1])

    while que:
        cur_node = que.popleft()
        for next_node, d in nodes[cur_node]:
            if graph[next_node] > graph[cur_node] + d:
                graph[next_node] = graph[cur_node] + d
                que.append(next_node)

    return len([True for dist in graph.values() if dist <= K])