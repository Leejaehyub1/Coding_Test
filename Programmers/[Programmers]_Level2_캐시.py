def solution(cacheSize, cities):
    answer = 0
    stack = []

    if (cacheSize == 0):
        return len(cities) * 5

    for c in cities:
        c = c.lower()
        if c in stack:
            answer += 1
            stack.append(stack.pop(stack.index(c)))

        else:
            if len(stack) == cacheSize:
                stack.pop(0)
            stack.append(c)
            answer += 5

    return answer