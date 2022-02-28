package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1463 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] DP = new int[N+3];
		DP[0] = 0;
		DP[1] = 0;
		DP[2] = 1;
		DP[3] = 1;
		if(4 <= N) {
			for(int i=3;i<=N;i++) {
				int temp = Integer.MAX_VALUE;
				if(i%3 == 0) {
					temp = Math.min(temp, DP[i/3]+1);
				}
				if(i%2 == 0) {
					temp = Math.min(temp, DP[i/2]+1);
				}
				DP[i] = Math.min(temp, DP[i-1]+1);
				
			}
		}

		System.out.println(Arrays.toString(DP));

	}

}
