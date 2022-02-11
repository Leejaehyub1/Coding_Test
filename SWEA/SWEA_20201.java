package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SWEA_2001 {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int [][] matrix = new int[N][N];
			int max = 0;
			//N=5, M=2인 경우 i는 3까지 가야함
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) {
					 matrix[i][k] = Integer.parseInt(st.nextToken());
				}
			}
//			for(int i=0;i<N;i++) {
//				for(int k=0;k<N;k++) {
//					System.out.println(matrix[i][k]);
//				}
//			}
			int temp_max = 0;
			for(int i=0; i<N-M+1; i++) {
				for(int k=0;k<N-M+1;k++) {
//					System.out.println(i + " " + k);
					temp_max = 0;
					for(int a=0;a<M;a++) {
						for(int b=0;b<M;b++) {
							temp_max += matrix[i+a][k+b];
						}
					}
					max = Math.max(temp_max, max);
				}
//				
//				if(max < temp_max) {
			}
			System.out.printf("#%d %d\n",test_case, max);
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}