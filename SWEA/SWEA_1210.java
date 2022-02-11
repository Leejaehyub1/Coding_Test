package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1210 
{
	static int T=10;
	static int N = 100;
	static int [][] arr = new int[N][N];
	static int x = 0;
	static int y = 0;
	static int dir = 0;
	static boolean moving_side = false;
	static int [] dx = {0, 0, -1};
	static int [] dy = {-1, 1, 0};
	public static void check() {
		int nx;
		int ny;
		for(int i=0; i<3;i++) {
			nx = x+dx[i];
			ny = y+dy[i];
			if(0<=nx && 0<=ny && ny<N && arr[nx][ny]==1) {
				if(moving_side && (i == (1-dir))){
					continue;
				}
				
				if(i < 2) {
					moving_side = true;
				}
				dir = i;
				break;
			}
		}
	}
	
	public static void move(int dir) {
		x = x+dx[dir];
		y = y+dy[dir];
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= T; test_case++)
		{
			br.readLine();
			for(int i=0;i<N;i++) {
				String s[] = br.readLine().split(" ");
				for(int k=0;k<N;k++){
					int temp = Integer.parseInt(s[k]);
					arr[i][k] = temp;
					if(temp == 2) {
						x = i;
						y = k;
					}
				}
			}
			while(x != 0) {
				check();
				move(dir);

			}
			System.out.println("#"+test_case + " "+y);

		}
	}
}