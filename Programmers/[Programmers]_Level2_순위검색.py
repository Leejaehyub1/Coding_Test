from itertools import combinations
from collections import defaultdict


# https://tech.kakao.com/2021/01/25/2021-kakao-recruitment-round-1/

def solution(info, query):
    answer = []
    info_dict = defaultdict(list)

    for i in info:
        i = i.split()
        for k in range(len(i)):
            temp = (combinations(i[:-1], k))
            for t in temp:
                t_final = ''.join(t)
                info_dict[t_final].append(int(i[-1]))

    for key in info_dict.keys():
        info_dict[key].sort()

    for q in query:
        q = q.split(' ')
        th = int(q[-1])
        temp_query = q[:-1]

        for asd in range(3):
            temp_query.remove('and')
        while '-' in temp_query:
            temp_query.remove('-')

        q_final = ''.join(temp_query)
        score_list = info_dict[q_final]

        if len(score_list) > 0:
            start, end = 0, len(score_list)
            while (end > start):
                mid = (start + end) // 2
                if score_list[mid] >= th:
                    end = mid
                else:
                    start = mid + 1

            answer.append(len(score_list) - start)
        else:
            answer.append(0)

    return answer