package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Samsung_BOJ_23288 {
	static int[][] map;
	static int[][] count;
	static boolean[][] visited;
	static boolean[][] visited_2;
	
	static int dir = 0; //0~4는 각각 동, 남, 서, 북(시계방향)
	static int [] dr = {0, 1, 0, -1};
	static int [] dc = {1, 0, -1, 0};
	
	static int N;
	static int M;
	static int K;
	
	static int cnt;
	static int[][] dial= new int[][] {	{0, 2, 0},
										{4, 1, 3},
										{0, 5, 0},
										{0, 6, 0}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		
		map = new int[N][M];
		count = new int[N][M];
		visited = new boolean[N][M];
		visited_2 = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<M;k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();
		
		for(int r=0; r<N;r++) {
			for(int c=0;c<M;c++) {
				if(!visited[r][c]) {
					cnt = 1;
					visited[r][c] = true;
					dfs(r, c);
					
					visited_2[r][c] = true;
					get_count(r, c);
				} 
			}
		}
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(count[i]));
//		}
		int ans = 0;
		int r=0, c=0;
//		for(int i=0;i<4;i++) {
//			roll(i);
//			for(int k=0;k<4;k++) {
//				System.out.println(Arrays.toString(dial[k]));
//			}
//			System.out.println();
//		}
		for(int i=0;i<K;i++) {
			

			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(!(0<=nr && nr <N && 0<=nc && nc<M)){
				dir = (dir+2)%4;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}
			roll(dir);
//			for(int k=0;k<4;k++) {
//			System.out.println(Arrays.toString(dial[k]));
//			}
//			System.out.println();
			r = nr;
			c = nc;
			ans += count[nr][nc];
			
			int bottom = dial[3][1];
			if(map[nr][nc] < bottom) {
				dir = (dir+1)%4;
			}
			else if(bottom < map[nr][nc]) {
				dir = (dir+3)%4;
			}
//			System.out.printf("bottom=%d nr=%d, nc=%d, ans=%d, dir=%d\n",bottom, nr+1,nc+1,ans, dir);
		
		}
		System.out.println(ans);
		
	}
	
	public static void dfs(int r, int c) {
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(0<=nr && nr <N && 0<= nc && nc < M) {
				if(map[r][c]==map[nr][nc] && !visited[nr][nc]) {
					visited[nr][nc] = true;
					cnt ++;
					dfs(nr, nc);

				}
			}
		}
	}
	public static void get_count(int r, int c) {
		count[r][c] = cnt * map[r][c];
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(0<=nr && nr <N && 0<= nc && nc < M) {
				if(map[r][c]==map[nr][nc] && !visited_2[nr][nc]) {
					visited_2[nr][nc] = true;
					count[nr][nc] = cnt * map[r][c];
					get_count(nr, nc);
				}
			}
		}
	}
	
	public static void roll(int dir) {
		int temp = -1;
		
		switch(dir){
			case 0:
				
				temp = dial[1][2];
				dial[1][2] = dial[1][1];
				dial[1][1] = dial[1][0];
				dial[1][0] = dial[3][1];
				dial[3][1] = temp;
				break;
			case 1:
				temp = dial[3][1];
				for(int i=3; i>0;i--) {
					dial[i][1] = dial[i-1][1];
				}
				dial[0][1] = temp;
				break;
			case 2:
				temp = dial[1][0];
				dial[1][0] = dial[1][1];
				dial[1][1] = dial[1][2];
				dial[1][2] = dial[3][1];
				dial[3][1] = temp;
				break;
			case 3:
				temp = dial[0][1];
				for(int i=0; i<3;i++) {
					dial[i][1] = dial[i+1][1]; 
				}
				dial[3][1] = temp;
				break;
				
		}
	}

}
