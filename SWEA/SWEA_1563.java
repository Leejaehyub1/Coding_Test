package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {
	static int N;
	static int M;
	static int R;
	static int C;
	static int L;
	static int[][] matrix;
	static boolean[][] visited;
	static Queue<int[]> queue;
	
	//pipe_matrix[dir][현재 pipe번호][옮겨가려는 pipe번호] 										
	static int[][][] pipe_matrix = { {},
	                {{0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 1, 1, 0, 0, 1, 1, 0},
	                 {0, 1, 1, 0, 0, 1, 1, 0},
	                 {0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 1, 1, 0, 0, 1, 1, 0},
	                 {0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 1, 1, 0, 0, 1, 1, 0}},

	                {{0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 1, 1, 0, 1, 0, 0, 1},
	                 {0, 1, 1, 0, 1, 0, 0, 1},
	                 {0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 1, 1, 0, 1, 0, 0, 1},
	                 {0, 1, 1, 0, 1, 0, 0, 1},
	                 {0, 0, 0, 0, 0, 0, 0, 0}},

	                {{0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 1, 0, 1, 1, 1, 0, 0},
	                 {0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 1, 0, 1, 1, 1, 0, 0},
	                 {0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 1, 0, 1, 1, 1, 0, 0},
	                 {0, 1, 0, 1, 1, 1, 0, 0}},

	                {{0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 1, 0, 1, 0, 0, 1, 1},
	                 {0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 1, 0, 1, 0, 0, 1, 1},
	                 {0, 1, 0, 1, 0, 0, 1, 1},
	                 {0, 1, 0, 1, 0, 0, 1, 1},
	                 {0, 0, 0, 0, 0, 0, 0, 0},
	                 {0, 0, 0, 0, 0, 0, 0, 0}}};
//	// next[dir][옮겨가려는 pipe번호] = 다음 좌표의 dir
//	static int[][] getDir = {	{9, 0, 0, 9, 9, 3, 2, 9},
//								{9, 1, 1, 9, 3, 9, 9, 2},
//								{9, 2, 9, 2, 0, 1, 9, 9},
//								{9, 3, 9, 3, 9, 9, 1, 0}};

	static int[] dr = {-1, 1, 0, 0};	//상, 하, 좌, 우
	static int[] dc = {0, 0, -1, 1};	//상, 하, 좌, 우

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder("");
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//세로
			M = Integer.parseInt(st.nextToken());	//가로
			R = Integer.parseInt(st.nextToken());	//맨홀 뚜껑 세로위치
			C = Integer.parseInt(st.nextToken());	//맨홀 뚜껑 가로위치
			L = Integer.parseInt(st.nextToken());	//시간
			matrix = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<M;k++) {
					matrix[i][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			queue = new LinkedList<int[]>();
			queue.add(new int[] {R, C});
			ans++;
			visited[R][C] = true;
			for(int i=0;i<L-1;i++) {
				int length = queue.size();
				
				//현재의 queue size 만큼만 돌린다. 딱 1시간만 행할수 있는
				for(int k=0;k<length;k++) {
					int[] temp = queue.poll();
					int r = temp[0];
					int c = temp[1];
					for(int d=0;d<4;d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(0<=nr && nr<N && 0<=nc && nc<M) {
							int current_pipe = matrix[r][c];
							int future_pipe = matrix[nr][nc];
							if(pipe_matrix[d+1][current_pipe][future_pipe] == 1) {
								if(!visited[nr][nc]) {
									queue.add(new int[] {nr, nc});
									visited[nr][nc] = true;
									ans++;
								}
							}
						}
							
					}
				}
			}
			System.out.printf("#%d %d\n",tc,ans);
		}
		
		
	}

}
