from itertools import combinations


def solution(relation):
    row = len(relation)
    col = len(relation[0])

    candidate = []
    for i in range(1, col + 1):
        candidate.extend(combinations(range(col), i))

    result = []
    for can in candidate:
        temp_list = []
        for rel in relation:
            temp = []
            for c in can:
                temp.append(rel[c])

            temp_list.append(tuple(temp))

        if (len(set(temp_list)) == len(relation)):
            result.append(can)

    answer = set(result[:])
    for i in range(len(result)):
        for k in range(i + 1, len(result)):
            if set(result[i]).issubset(result[k]):
                answer.discard(result[k])

    return len(answer)
