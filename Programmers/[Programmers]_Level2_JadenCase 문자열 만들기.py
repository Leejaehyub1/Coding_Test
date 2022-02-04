def solution(s):
    answer = []
    s = s.lower()
    s = s.split(' ')

    for t in s:
        answer.append(t.capitalize())

    return ' '.join(answer)