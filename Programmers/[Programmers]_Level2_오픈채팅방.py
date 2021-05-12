def solution(record):
    d = dict()
    answer = []

    for rec in record:
        status = rec.split(' ')
        if (status[0] != "Leave"):
            d[status[1]] = status[2]

    for rec in record:
        status = rec.split(' ')
        if (status[0] == "Enter"):
            answer.append("{}님이 들어왔습니다.".format(d[status[1]]))
        elif (status[0] == "Leave"):
            answer.append("{}님이 나갔습니다.".format(d[status[1]]))

    return answer