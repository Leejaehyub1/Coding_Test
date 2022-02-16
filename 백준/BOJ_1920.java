package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(arr));
		int M = Integer.parseInt(br.readLine());
		int [] arr_2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr_2[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(arr_2));
		Arrays.sort(arr);
		for(int i=0;i<M;i++) {
			int t = arr_2[i];
			int ans = Arrays.binarySearch(arr, t);
			if(ans <0) {
				sb.append("0");
				sb.append("\n");
			}
			else {
				sb.append("1");
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
