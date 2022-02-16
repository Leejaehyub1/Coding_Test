package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992 {
	static int [][] arr;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		sb = new StringBuilder("");
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int k=0;k<N;k++) {
				arr[i][k] = s.charAt(k) - '0';
			}
		}
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<N;k++) {
//				System.out.print(arr[i][k]);
//			}
//			System.out.println();
//		}
		
		calculate(0, 0, N);
		System.out.println(sb);
	}
	public static void calculate(int r,int c, int size) {
		int value = arr[r][c];
		boolean flag = true;
		for(int i=0;i<size;i++) {
			for(int k=0;k<size;k++) {
				if(value != arr[r+i][c+k]) {
					flag = false;
					break;
				}
			}
			if(!flag)	break;
		}
		
		if(flag) {
			sb.append(arr[r][c]);
			return;
		}
		else {
			sb.append("(");
			calculate(r,c,size/2);
			calculate(r,c+size/2,size/2);
			calculate(r+size/2,c,size/2);
			calculate(r+size/2,c+size/2,size/2);
			sb.append(")");
		}
	}

}
