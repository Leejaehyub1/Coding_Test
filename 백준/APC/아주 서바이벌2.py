import sys
T, N = map(int, input().split())

cheat_num = []
stop = []
game = [[1,[]] for _ in range(N+1)]


for _ in range(T):
    log = list(sys.stdin.readline().split())
    num, player, action, num1 = log[0], int(log[1]), log[2], int(log[3])
    # print(num, player, action, num1)
    if action == 'M':
        game[player][0] = num1

    elif action == 'F':
        if game[player][0] != num1:
            cheat_num.append(int(num))
            game[player][1].append(num1)
        else:
            game[player][1].append(num1)


    elif action == 'C':
        num2 = int(log[4])
        cheat = False
        if num1 in game[player][1]:
            game[player][1].remove(num1)
        else:
            cheat = True

        if num2 in game[player][1]:
            game[player][1].remove(num2)
        else:
            cheat = True
        if cheat == True:
            cheat_num.append(int(num))

    else:
        if game[player][0] != game[num1][0]:
            cheat_num.append(int(num))
            stop.append(player)


print(len(cheat_num))
if (len(cheat_num) > 0):
    for c in cheat_num:
        print(c, end=" ")
    print()
stop = list(set(stop))
stop.sort()
print(len(stop))
for s in stop:
    print(s, end=" ")





