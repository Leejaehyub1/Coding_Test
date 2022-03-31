package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_02 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] DP = new int[N][3];
		int[][] cost = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<3;k++) {
				cost[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		for(int k=0;k<3;k++) {
			DP[0][k] = cost[0][k];
		}
		for(int i=1;i<N;i++) {
			DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + cost[i][0];
			DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + cost[i][1];
			DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + cost[i][2];
		}
//		int ans = DP[N-1][0];
//		for(int k=1;k<3;k++) {
//			ans = Math.min(ans, DP[N-1][k]);
//		}
		
		int ans = Math.min(DP[N-1][0], Math.min(DP[N-1][1], DP[N-1][2]));
		
		System.out.println(ans);
	}

}
