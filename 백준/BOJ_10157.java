package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157 {
	static int dir = 0;
	static int[] dr = {-1, 0, +1, 0};
	static int[] dc = {0, +1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int [][] arr = new int[R][C];
		int r = R-1;
		int c = 0;
		int dir = 0;
		if(C*R < K) {
			System.out.println("0");
		}
		else {
			for(int i=1; i<=K;i++) {
//				System.out.printf("%d %d\n",r,c);
				arr[r][c] = i;
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				
				if(nr<0 || R<=nr || nc<0 || C<=nc || arr[nr][nc] != 0) {
					dir = (dir+1)%4;
					nr = r+dr[dir];
					nc = c+dc[dir];
				}
				r = nr;
				c = nc;
				
			}
//			for(int i=0;i<R;i++) {
//				for(int k=0;k<C;k++) {
//					System.out.printf("%04d ", arr[i][k]);
//				}
//				System.out.println();
//			}
			System.out.printf("%d %d\n",c-dc[dir]+1, R-r+dr[dir]);
		}
		
		
	}

}
