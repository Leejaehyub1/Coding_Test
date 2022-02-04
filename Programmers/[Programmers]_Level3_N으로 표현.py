def solution(N, number):
    if N == number:   return 1

    DP = [{N}]

    for i in range(0, 8):
        temp = set()
        for k in range(0, i+1):
            for d in DP[i]:
                for t in DP[i - k]:
                    temp.add(d + t)
                    temp.add(d - t)
                    temp.add(d * t)
                    if t != 0:
                        temp.add(d // t)

        print(i)
        if number in temp:
            print(temp)
            print("answer is %d"%(i+1))
            return i + 1
        DP.append(temp)

    return -1

solution(5,12)