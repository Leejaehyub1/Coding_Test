package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2630 {
	static int[][] arr;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		Calculate(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	public static void Calculate(int r, int c, int size) {
		int temp = 0;
		if(size ==1) {
			if(arr[r][c]==1) {
				blue++;
				return;
			}
			if(arr[r][c]==0) {
				white++;
				return;
			}
		}
		for(int i=0;i<size;i++) {
			for(int k=0;k<size;k++) {
				temp += arr[r+i][c+k];
			}
		}
		if(temp == 0) {
			white++;
			return;
		}
		if(temp == size*size) {
			blue++;
			return;
		}
		Calculate(r, c,size/2);
		Calculate(r+size/2, c,size/2);
		Calculate(r, c+size/2,size/2);
		Calculate(r+size/2, c+size/2,size/2);
		
		
	}

}
