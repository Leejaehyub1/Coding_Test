package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2491 {
	static int[] arr;
	static int[] DP_increase;
	static int[] DP_decrease;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int asc_count = 1;
		int asc_value = 0;
		int desc_count = 1;
		int desc_value = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		asc_count = 1;
		desc_count = 1;
		asc_value = arr[0];
		desc_value = arr[0];
		int max = 1;
		for(int i=1;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if( asc_value <= arr[i]) {
				asc_count++;
			}
			else {
				asc_count = 1;
			}
			asc_value = arr[i];
			max = Math.max(max,  asc_count);
//			
			if( desc_value >= arr[i]) {
				desc_count++;
			}
			else {
				desc_count = 1;
			}
			desc_value = arr[i];
			max = Math.max(max,  desc_count);
		}
		System.out.println(max);
	}	
}
