package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] DP = new int[N+1];
		int [] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			int temp = Integer.parseInt(br.readLine());
			arr[i] = temp;
		}
		DP[1] = arr[1];
		if(N >= 2) {
			DP[2] = arr[1]+arr[2];
		}
		
		if(N >= 3) {
			DP[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);
		}
		
		if(4 <= N) {
			for(int i=4;i<=N;i++) {
				DP[i] = Math.max(DP[i-2]+arr[i], DP[i-3]+arr[i-1]+arr[i]);
			}
		}
		
		System.out.println(Arrays.toString(DP));
		System.out.println(DP[N]);
		

	}

}
