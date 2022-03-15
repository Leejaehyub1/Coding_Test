package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14696 {
	static int [] A_list = new int[4];
	static int [] B_list = new int[4];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			Arrays.fill(A_list, 0);
			Arrays.fill(B_list, 0);
			st = new StringTokenizer(br.readLine());
			int a_len = Integer.parseInt(st.nextToken());
			for(int k=0;k<a_len;k++) {
				A_list[Integer.parseInt(st.nextToken())-1]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int b_len = Integer.parseInt(st.nextToken());
			for(int k=0;k<b_len;k++) {
				B_list[Integer.parseInt(st.nextToken())-1]++;
			}
			System.out.println(check());
			
		}
	}
	public static char check() {
		for(int i=3;0<=i;i--) {
			if(B_list[i] < A_list[i])	return 'A';
			if(A_list[i] < B_list[i])	return 'B';
		}
		
		return 'D';
	}
}
