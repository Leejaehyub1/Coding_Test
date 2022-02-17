package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2605 {
	static int [] arr;
	static ArrayList<Integer> aa = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int value = Integer.parseInt(st.nextToken());
			for(int k=0;k<value;k++) {
				arr[i-k] = arr[i-k-1];
			}
			arr[i-value] = i;
		}
		for(int i=1;i<=N;i++) {
			System.out.print(arr[i]+" ");
		}
		
		

	}

}
