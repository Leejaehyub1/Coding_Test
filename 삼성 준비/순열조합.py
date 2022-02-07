# def permutation(arr, r):
#     for i in range(len(arr)):
#         if r==1:
#             yield [arr[i]]
#         else:
#             for next in permutation(arr[:i]+arr[i+1:], r-1):
#                 yield [arr[i]]+next
#
# def combination(arr,r):
#     for i in range(len(arr)):
#         if r==1:
#             yield [arr[i]]
#         else:
#             for next in combination(arr[i+1:], r-1):
#                 yield [arr[i]]+next
#
# def permutation2(arr,r):
#     for i in range(len(arr)):
#         if r==1:
#             yield [arr[i]]
#         else:
#             for next in permutation2(arr,r-1):
#                 yield [arr[i]] + next
#
# def combination2(arr,r):
#     for i in range(len(arr)):
#         if r==1:
#             yield [arr[i]]
#         else:
#             for next in combination2(arr[i:], r-1):
#                 yield [arr[i]] + next
#
# arr = [1,2,3,4]
# r=2
# for c in combination(arr,r):
#     print(c, end=" ")
# print()
# for c in permutation(arr,r):
#     print(c, end=" ")
# print()
# for c in combination2(arr, r):
#     print(c, end=" ")
# print()
# for c in permutation2(arr, r):
#     print(c, end=" ")


n = 0  # 숫자 1, 2, 3, ...
step = 1  # 증가/감소 크기: 1, -1
y = 0  # 줄 위치
x = -1  # 칸 위치 (배열 선두보다 한칸 앞)
size = 5  # 배열 크기 (5*5 배열)
arr = [[0] * size for i in range(size)]  # 2차원 배열 구조

while True:
    for _ in range(size):  # 몇 칸 진행할까
        n += 1
        x += step
        arr[y][x] = n
    size -= 1
    if size < 1:  # 출력할 게 없으면 종료
        break
    for _ in range(size):  # 몇 줄 진행할까
        n += 1
        y += step
        arr[y][x] = n
    step = -step  # 증감 방향을 반대로

# for a in arr:
#     print(a)

n=0
r,c = 0, -1
size=5
step = 1
while True:
    for _ in range(size):
        n += 1
        c += step
        arr[r][c] = n
    size -= 1
    if size<1:
        break
    for _ in range(size):
        n += 1
        r += step
        arr[r][c] = n
    size = -size

for m in arr:
    print(m)