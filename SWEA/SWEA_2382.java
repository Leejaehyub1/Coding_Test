package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2382 {
	static int N, M, K, cost;
	static int[][] matrix;
	static ArrayList<int []>[] diff;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder("");
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			answer = 0;
			diff = new ArrayList[2*N];
			init();
//			for(int[] temp: diff) {
//				System.out.println(Arrays.toString(temp));
//			}
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) {
					matrix[i][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int k=0;k<N;k++) {
					check(i, k);
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	public static void check(int r, int c) {
		for(int i=0;i<2*N;i++) {
			int count = 0;
			for(int[] arr: diff[i]) {
				int nr = r + arr[0];
				int nc = c + arr[1];
				if(0<=nr && nr<N && 0<=nc && nc<N && matrix[nr][nc] == 1) {
					count++;
				}
			}
			if(diff[i].size() <= count*M) {
				answer = Math.max(answer,  count);
			}
		}
		
		
//		answer = Math.max(answer,  count);
	}
	
	public static void init() {
		for(int A=1; A<=2*N; A++) {
			ArrayList<int []> temp = new ArrayList<int []>();
			for(int i=-A+1; i<A;i++) {	
				for(int k=-A+1; k<A;k++) {
					if(Math.abs(i) + Math.abs(k) < A) {
						temp.add(new int[] {i, k});
					}
				}
			}
			diff[A-1] = temp;
		}
		
	}
}
