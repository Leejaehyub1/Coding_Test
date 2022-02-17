package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {
	static int N = 5;
	static int [][] arr = new int[N][N];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int N = 5;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
