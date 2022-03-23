package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1676 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(N));
	}
	public static int factorial(int N) {
		int ans = 0;
		for(int i=0;i<3;i++) {
			N /= 5;
			ans+=N;
		}
		return ans;
	}

}
