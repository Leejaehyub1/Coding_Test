//#include <string>
//#include <vector>
//#include <queue>
//#include <iostream>
//
//using namespace std;
//
//int solution(vector<int> priorities, int location) {
//    int answer = 0;
//    int max = *max_element(priorities.begin(), priorities.end());
//    while (true)
//    {
//        for (int i = 0; i < priorities.size(); ++i)
//        {
//            if (priorities[i] == max)
//            {
//                ++answer;
//
//                if (i == location)
//                    return answer;
//
//                priorities[i] = 0;
//                max = *max_element(priorities.begin(), priorities.end());
//            }
//        }
//    }
//}
//int main() {
//    //vector<int> v = { 2,1,3,2 };
//    vector<int> v = {1,1,9,1,1,1};
//    cout << solution(v, 0) << endl;
//    return 0;
//}