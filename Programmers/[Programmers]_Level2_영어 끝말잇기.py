def solution(n, words):
    visited = [words[0]]

    for i in range(1, len(words)):
        w = words[i]
        if ((w in visited) or w[0] != words[i - 1][-1]):
            return [(i % n) + 1, (i // n) + 1]

        else:
            visited.append(w)

    return [0, 0]