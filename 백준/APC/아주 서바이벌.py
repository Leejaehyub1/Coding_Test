import sys
T, N = map(int, input().split())

class person():
    place = 1
    item = []

    def move(self, p):
        self.place = p

    def farming(self, num):
        if num != self.place:
            return -1
        else:
            self.item.append(num)
            return 1

    def crafting(self, n1, n2):
        #n1 없음
        if n1 not in self.item:
            #n2 있음
            if n2 in self.item:
                self.item.remove(n2)
                return -1

            #n2 없음
            return -1

        #n1 있음
        else:
            self.item.remove(n1)
            if n2 not in self.item:
                return -1
            else:
                self.item.remove(n2)
                return 1

def attack(a,b):
    if a.place != b.place:
        return -1
    return 0

cheat_num = []
stop = []
dict = {}
for i in range(N):
    temp = person()
    dict[i] = temp

for _ in range(T):
    log = list(sys.stdin.readline().split())
    num, player, action, num1 = log[0], int(log[1]), log[2], int(log[3])
    if action == 'M':
        dict[player].move(num1)

    elif action == 'F':
        if (dict[player].farming(num1) == -1):
            cheat_num.append(int(num))

    elif action == 'C':
        num2 = int(log[4])
        if(dict[player].crafting(num1, num2) == -1):
            cheat_num.append(int(num))

    else:
        if (attack(dict[player], dict[num1]) == -1):
            cheat_num.append(int(num))
            stop.append(player)


print(len(cheat_num))
for c in cheat_num:
    print(c, end=" ")
print()

stop = list(set(stop))
stop.sort()
print(len(stop))
for s in stop:
    print(s, end=" ")





