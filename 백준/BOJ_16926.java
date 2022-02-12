package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
	static int N, M, R;
	static int[][] map, board;
	static int b_dir = 0; //delta % 4
	static int b_nx, b_ny;
	
	static int m_dir = 0;
	static int m_nx, m_ny;
	static int [][] dxdy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 반시계 방향

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		board = new int[N][M];
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j< M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 원본 배열
		
		for(int rcnt = 0; rcnt < Math.min(N, M)/2 ; rcnt++) { //큰배열, 작은 배열 --- 갯수
			search(N-2*rcnt, M-2*rcnt, rcnt);
		}
		
		for(int i = 0; i< N; i++) {
			for(int j = 0;j<M; j++) {
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void search(int n, int m, int rstart) { // n x m rstart  배열 시작점
		int rotate = R % ((n-1+m-1)*2); // 돌아야 될 횟수
		b_dir = 0; //delta % 4
		b_nx = rstart;
		b_ny = rstart;
		
		m_dir = 0;
		m_nx = rstart;
		m_ny = rstart;
		
		for(int i = 0; i < rotate; i++) {
			move_index_board(n,m,rstart);	//map의 rstart,rstart의 값이 
		}
		board[b_nx][b_ny] = map[rstart][rstart]; //2,0   0,0 
		
		for(int i = 0 ; i < ((n-1+m-1)*2)-1; i++) {
			move_index_board(n,m,rstart);
			move_index_map(n,m,rstart);
			board[b_nx][b_ny] = map[m_nx][m_ny];
		}
		
	}
	
	public static boolean vertex_check(int x,int y,int n,int m, int rstart) {
		return ((x == rstart && y == (rstart+m-1) ) || (x == rstart && y == rstart) || (x == (rstart+n-1) && y == rstart+m-1) || (x == rstart+n-1 && y == (rstart)));
	}
	public static void move_index_board(int n, int m, int rstart) {
		b_nx = b_nx + dxdy[b_dir][0];
		b_ny = b_ny + dxdy[b_dir][1];	
		if(vertex_check(b_nx,b_ny,n,m,rstart)) { // 꼭짓점일 때
			b_dir = (b_dir+1)%4;
		}
	}
	public static void move_index_map(int n, int m, int rstart) {
		m_nx = m_nx + dxdy[m_dir][0];
		m_ny = m_ny + dxdy[m_dir][1];
		
		if(vertex_check(m_nx,m_ny,n,m,rstart)) { // 꼭짓점일 때
			m_dir = (m_dir+1)%4;
		}
	}
}
