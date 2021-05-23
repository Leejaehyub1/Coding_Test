def solution(skill, skill_trees):
    answer = 0

    skill = list(skill)
    for st in skill_trees:
        temp = skill[:]
        for s in st:
            if (s in temp):
                if (s == temp[0]):
                    temp.pop(0)

                else:
                    answer -= 1
                    break

        answer += 1

    return answer