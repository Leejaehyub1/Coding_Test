package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
	static int[][] matrix;
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(matrix[i], Integer.MAX_VALUE/2-1);
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			matrix[r-1][c-1] = 1;
			matrix[c-1][r-1] = 1;
			
		}
		for(int i=0;i<N;i++) {
			matrix[i][i] = 0;
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				for(int q=0;q<N;q++) {
					matrix[k][q] = Math.min(matrix[k][i]+matrix[i][q], matrix[k][q]);
				}
			}
		}
		
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(matrix[i]));
//		}
		int index = -1;
		int sum = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			int temp = 0;
			for(int k=0;k<N;k++) {
				temp += matrix[i][k];
			}
			if(temp < sum) {
				index = i;
				sum = temp;
			}
		}
		System.out.println(index+1);

	}

}
