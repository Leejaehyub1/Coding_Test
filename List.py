#List 정리.
#출처: https://wikidocs.net/16041

#Stack
stack = []

stack.append('a')   #push 대신 append를 사용한다.
stack.append('b')
stack.append('c')
stack.pop(-1)   #pop(), pop(-1) 똑같음. -> c가 나옴
stack.pop(0)    #첫번째 원소 pop (Queue 에서 사용) -> a가 나옴





#append와 extend의 차이점.
#extend는 iterable한 모든 항목을 넣는다.
x = ['a', 'b', 'c']
y = ['d', 'e']
x.append(y)
print(x) #['a', 'b', 'c', ['d', 'e']]

x = ['a', 'b', 'c']
y = ['d', 'e']
x.extend(y)
print(x) #['a', 'b', 'c', 'd', 'e']

#만약 문자열이면?
x = ['aaa', 'bbb', 'ccc']
y = 'def'
x.extend(y)
print(x) #['aaa', 'bbb', 'ccc', 'd', 'e', 'f']



#reverse: 거꾸로 뒤집기. (내림차순X)
a = [1,4,2,5,8]
a.reverse() #[8,5,2,4,1]

#sort
a = [1,4,2,5,8]
a.sort() #[1,2,4,5,8]

a.sort(reverse=True)    #[8,5,4,2,1]