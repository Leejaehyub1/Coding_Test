#Set 정리


#url: https://velog.io/@ednadev/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EB%94%95%EC%85%94%EB%84%88%EB%A6%ACdictionary%EC%99%80-set
#수학에서의 집합과 비슷하다.
#Dictionary에서 Key만 활용하는 데이터 구조라고 생각해도 된다.

#******중복 제거 가능********
a = [1,1,2,2,3,3,4,5,6]
a = set(a)
print(a)    #[1,2,3,4,5,6]



#추가, 삭제
a = set([1,2])
a.add(3)        #{1, 2, 3}
a.update({4,5})    #{1, 2, 3, 4, 5}
a.remove(3)     #{1, 2, 4, 5}
a.discard(4)    #{1, 2, 5}
a.discard(4)    #여전히 {1, 2, 5}
#remove()는 지울 원소가 없으면 Error
#discard()는 지울 원소가 없어도 정상종료.



#교집합, 합집합, 차집합 가능하다.
a = {1,2,3}
b = {1,2,3,4}

print(a.union(b))           #합집합을 return
print(a.intersection(b))    #교집합을 return
print(a.difference(b))      #차집합을 return
print(a.issubset(b))        #a가 b의 부분집합인지 여부 return(True/False)