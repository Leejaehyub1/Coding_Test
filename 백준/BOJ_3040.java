package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3040 {
	static int N = 9;
	static int r = 7;
	static int [] arr = new int[N];
	static int [] num = new int[r];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		comb(0, 0, 0);
		

	}
	public static void comb(int cnt, int start, int sum) {
		if(cnt == r) {
			if(sum==100) {
				for(int i=0;i<r;i++) {
					System.out.println(num[i]);
				}
			}
				
			return;
		}
		
		for(int i=start; i<N; i++) {
			num[cnt] = arr[i];
			comb(cnt+1, i+1, sum+arr[i]);
		}
		
	}

}
