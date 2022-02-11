package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2563 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean [][] arr = new boolean[100][100]; 
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String [] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			for(int r=0; r<10;r++) {
				for(int c=0;c<10;c++) {
					arr[a+r][b+c] = true;
				}
			}
		}
		int ans = 0;
		for(int i=0;i<100;i++) {
			for(int k=0;k<100;k++) {
				if(arr[i][k])	ans+=1;
			}
		}
		System.out.println(ans);
		
	}

}
