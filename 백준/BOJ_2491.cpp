#include <iostream>
#include <vector>

using namespace std;
int main() {
	vector<int> arr;
	int N;

	cin >> N;
	for (int i = 0;i < N;i++) {
		int temp;
		cin >> temp;
		arr.push_back(temp);
	}
	int up_start = 0;
	int down_start = 0;
	int ans = INT_MIN;
	for (int i = 1;i < N;i++) {
		if (arr[i] < arr[i - 1]) {
			ans = max(i - up_start, ans);
			up_start = i;
			
		}
		if (arr[i-1] < arr[i]) {
			ans = max(i - down_start, ans);
			down_start = i;
			
		}
	}
	ans = max(N - down_start, ans);
	ans = max(N - up_start, ans);
	cout << ans;

	return 0;
}