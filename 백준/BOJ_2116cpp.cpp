#include <iostream>
#include <vector>

using namespace std;







int main() {
	int indexArr[6] = { 5, 3, 4, 1, 2, 0 };
	vector<vector<int>> v;
	
	int n;
	cin >> n;

	
	for (int i = 0;i < n;i++) {
		vector<int> temp_v;
		int temp;
		for (int k = 0;k < 6;k++) {
			cin >> temp;
			temp_v.push_back(temp);
		}
		v.push_back(temp_v);
	}


	int answer = 0;
	for (int i = 0; i < 6; i++) {
		int bottom_index = i;
		int bottom_value = v[0][bottom_index];
		
		int top_index = indexArr[i];
		int top_value = v[0][top_index];

		int local_ans = 0;
		int local_max = 0;
		for (int r = 0; r < 6; r++) {
			if (r != bottom_index && r != top_index) {
				local_max = max(local_max, v[0][r]);
			}
		}
		local_ans += local_max;

		if (1 < n) {
			for (int k = 1; k < n;k++) {
				bottom_value = top_value;
				for (bottom_index = 0;bottom_index < 6;bottom_index++) {
					if (bottom_value == v[k][bottom_index]) {
						break;
					}
				}
				cout << "aaa" << endl;
				top_index = indexArr[bottom_index];
				cout << "bbb" << endl;
				top_value = v[k][top_index];
				cout << "ccc" << endl;
				local_max = 0;
				for (int r = 0;r < 6;r++) {
					if (r != bottom_index && r != top_index) {
						local_max = max(local_max, v[k][r]);
					}
				}
				cout << "ddd" << endl;
				local_ans += local_max;
			}
		}
		answer = max(local_ans, answer);
	}
	cout << answer << endl;
	//for (int i = 0; i < n;i++) {
	//	for (int k = 0; k < 6; k++) {
	//		cout << v[i][k];
	//	}
	//	cout << endl;
	//}
	return 0;
}