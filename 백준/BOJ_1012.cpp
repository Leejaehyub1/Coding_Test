//#include <iostream>
//#include <vector>
//
//using namespace std;
//
//int dx[] = { 0, 0, -1, 1 };
//int dy[] = { -1, 1, 0, 0 };
//int M, N, K;
//
//
//vector <vector <int>> arr(50, vector<int>(50, 0));
//vector <vector <bool>> visited(50, vector<bool>(50, false));
//
//
//void DFS(int r, int c) {
//	visited[r][c] = true;
//	arr[r][c] = 2;
//	cout << r << ", " << c << endl;
//	for (int i = 0; i < 4;i++) {
//		int nr = r + dx[i];
//		int nc = c + dy[i];
//		if (0 <= nr && nr < N && 0 <= nc && nc < M) {
//			if (!visited[nr][nc] && arr[nr][nc] == 1) {
//				DFS(nr, nc);
//			}
//		}
//	}
//}
//void clear() {
//	for (int i = 0; i < 50;i++) {
//		for (int k = 0;k < 50;k++) {
//			arr[i][k] = 0;
//			visited[i][k] = false;
//		}
//	}
//}
//
//int main() {
//	int T = 0;
//	cin >> T;
//	for (int test_case = 0; test_case < T;test_case++) {
//		cin >> M >> N >> K;
//		int count = 0;
//		for (int i = 0; i < K;i++) {
//			int r, c;
//			cin >> c >> r;
//			arr[r][c] = 1;
//		}
//
//
//		for (int i = 0; i < N;i++) {
//			for (int k = 0; k < M;k++) {
//				if (arr[i][k] == 1) {
//					count += 1;
//					DFS(i, k);
//				}
//			}
//		}
//		cout << count << endl;
//		clear();
//	}
//	return 0;
//}
