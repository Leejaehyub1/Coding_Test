#Dictionary 정리

# url: https://wikidocs.net/16043
# immutable한 key와 mutable한 value를 사용



#기본적인 선언 방식
a = {"a":1, "b":2}
b = {}
c = dict()

# 배열을 Dict로 변환 가능
# 리스트 속 리스트
# 리스트 속 튜플 일 때 사용가능.
A = dict([['Alice', 1], ['Bob', 2]])
B = dict[('A',a):1, ('B',b):2]


#key 값으로는 문자열, 튜플, 정수, float 모두 가능
a = {"Alice":1, "Bob":2}    #Alice가 Key, 숫자 1은 Value
b = {('A',a):1, ('B',b):2}
c = {123:1, 777:2}
d = {3.5:1, 99.9:2}


#Key 값이 중복되는 경우 마지막 Value로 저장됨.
a = {"Alice":1, "Bob":2, "Alice":3}
# a = {"Alice":3, "Bob":2} 상태로 저장된다.
# 물론, 순서는 없다.
# 순서가 없으므로 index로 접근할 수 없다.


# 새로운 Key, Value 추가
a = {"Alice":1, "Bob":2}
a['Christin'] = 3



#Value는 변경 가능하다.
a = {"Alice":1, "Bob":2}
a["Alice"] = 3  #Key를 알고 있어야 한다.


# Key, Value 삭제 가능.
a = {"Alice":1, "Bob":2}
del a["Alice"]



# dictionary를 이용해서 For문을 돌릴 때
a = {"Alice":1, "Bob":2, "Chirstion":3}
#Key 값만 출력 된다.
for i in a:
    print(i)

#Value 값만 출력 된다.
for i in a.values():
    print(i)

#Key, Value 모두 출력된다.
for i,p in a.items():
    print(i, p)




# pprint 함수 사용하면 가독성이 좋다.
# 줄바꿈이 이쁘게 됨.
from pprint import pprint as pp
a = {"Alice":1, "Bob":2, "Chirstion":3}
pp(a)


