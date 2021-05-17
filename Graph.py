#Graph 정리.


#Dijkstra
#일반적으로는 O(n^2)
#노드가 많고 간선이 적으면 매우 비효율적이다.
#우선순위 큐 사용하면 O(NlogN)
graph = {
    'A': {'B': 8, 'C': 1, 'D': 2},
    'B': {},
    'C': {'B': 5, 'D': 2},
    'D': {'E': 3, 'F': 5},
    'E': {'F': 1},
    'F': {'A': 5}
}

import heapq

def dijkstra(graph, start):
    distances = {node:float('inf') for node in graph}
    distances[start] = 0
    queue = []
    heapq.heappush(queue, [distances[start], start])

    while queue:
        current_distance, current_destination = heapq.heappop(queue)

        if distances[current_destination] < current_distance:
            continue

        for new_destination, new_distance in graph[current_destination].items():
            dist = current_distance + new_distance
            if dist < distances[new_destination]:
                distances[new_destination] = dist
                heapq.heappush(queue, [dist, new_destination])
    return distances

print(dijkstra(graph, 'A'))