package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1107 {
	static int N;
	static int M;
	static boolean [] arr;
	static int[] num = new int[6];
	static int min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new boolean[10];
		if(M >0) {
			st = new StringTokenizer(br.readLine());
		}
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num] = true;
		}
		min = Math.abs(100-N);
		permutation(0);
		System.out.println(min);
	}
	
	public static void permutation(int cnt) {
		if(1<= cnt && cnt<=6) {
			int sum = 0;
			int len = 0;
			for(int i=0;i<cnt;i++) {
				sum += num[i]*((int)Math.pow(10, i));	// 6 2 3 3 2 4
			}
			min = Math.min(cnt+Math.abs(N-sum), min);
		}
		if(cnt==6)	return;
		for(int i=0;i<10;i++) {
			if(!arr[i]) {
				num[cnt] = i;
				permutation(cnt+1);
			}
		}
	}

}
