package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int[N][3];
		int [][] DP = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<3;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		DP[0][0] = arr[0][0];
		DP[0][1] = arr[0][1];
		DP[0][2] = arr[0][2];
		for(int i=1;i<N;i++) {
			DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + arr[i][0];
			DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + arr[i][1];
			DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + arr[i][2];
		}
		System.out.println(Math.min(Math.min(DP[N-1][0], DP[N-1][1]), DP[N-1][2]));
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<3;k++) {
//				System.out.printf("%d ", DP[i][k]);
//			}
//			System.out.println();
//		}
		
//		int r = Integer.parseInt(st.nextToken());
//		int c = Integer.parseInt(st.nextToken());
//		System.out.printf("%d %d %d\n", N, r ,c);
		
	}

}
