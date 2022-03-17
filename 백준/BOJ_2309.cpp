//#include <iostream>
//#include <algorithm>
//
//using namespace std;
//
//int main() {
//
//	int arr[9];
//	int sum = 100;
//	for (int i = 0; i < 9;i++) {
//		cin >> arr[i];
//		sum -= arr[i];
//	}
//
//	//for (int i = 0; i < 9;i++) {
//	//	cout << arr[i];
//	//}
//	bool flag = false;
//	int r = 0, c = 0;
//	for (int i = 0;i < 9;i++) {
//		for (int k = i + 1;k < 9;k++) {
//			if (sum + arr[i] + arr[k] == 0) {
//				flag = true;
//				r = i;
//				c = k;
//				break;
//			}
//		}
//		if (flag) {
//			break;
//		}
//	}
//	int ans[7];
//	int count = 0;
//	for (int i = 0; i < 9; i++) {
//		if (i == r || i == c) {
//			continue;
//		}
//		ans[count++] = arr[i];
//	}
//	sort(ans, ans + sizeof(ans)/sizeof(ans[0]));
//	for (int i = 0; i < 7;i++) {
//		cout << ans[i] << " ";
//	}
//	
//
//
//
//	return 1;
//}