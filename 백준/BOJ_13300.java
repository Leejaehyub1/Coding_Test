package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13300 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [][] student = new int[6][2];
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			student[b-1][a] += 1;
		}
		for(int i=0;i<6;i++) {
			for(int k=0;k<2;k++) {
				if(0 < student[i][k]) {
					ans += ((student[i][k]-1)/K) + 1;
				}
			}
		}
		System.out.println(ans);
	}

}
