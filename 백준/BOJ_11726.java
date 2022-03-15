package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11726 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int [N+1];
		for(int i=1;i<N+1;i++) {
			if(i ==1) {
				arr[i] = 1; 
			}
			else if(i==2) {
				arr[i] = 2;
			}
			else {
				arr[i] = (arr[i-1] + arr[i-2])%10007;
			}
		}
		System.out.println(arr[N]);
	}

}
