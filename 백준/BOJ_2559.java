package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		if(K < N) {
			for(int i=0;i<=N-K;i++) {
				int temp = 0;
				for(int k=0;k<K;k++) {
					temp += arr[i+k];
				}
				max = Math.max(temp,  max);
			}
		}
		else {
			max = 0;
			for(int i=0;i<N;i++) {
				max += arr[i];
			}
		}
		System.out.println(max);
		

	}

}
