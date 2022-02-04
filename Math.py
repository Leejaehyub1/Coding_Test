#Math 정리.


#순열/조합 사용법
#permutations 또는 combination"s" -> 맨 뒤에 s 까먹지 말기!
from itertools import combinations
a = list(combinations(range(5),2))
#list와 같이 자료형을 정해줘야 하는 것 같다.
#마지막 인자 2는 뽑는 사람의 수
# a에는 5 choose 2 했을 때 나오는 모든 경우가 담긴다.


