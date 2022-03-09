package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9095 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		int [] DP = new int[11];
		DP[0] = 0;
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 4;
		for(int i=0;i<test_case;i++) {
			int N = Integer.parseInt(br.readLine());
			if(4 <= N) {
				for(int k=4;k<=N;k++) {
					DP[k] = DP[k-1] + DP[k-2] + DP[k-3];
				}
			}
			System.out.println(DP[N]);
		}
//		System.out.println(Arrays.toString(DP));
		

	}

}
