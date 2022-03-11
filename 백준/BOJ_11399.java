package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int ans = 0;
		int [] time = new int[N];
		for(int i=0;i<N;i++) {
			int temp = 0;
			for(int k=0;k<=i;k++) {
				temp += arr[k];
			}
			System.out.println(temp);
			ans += temp;
		}
		System.out.println(ans);

	}

}
