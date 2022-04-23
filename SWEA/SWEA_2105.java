package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_2105 {
	public static int N;
	public static int[][] matrix;
	public static boolean[][] visited_matrix;
	public static boolean[] visited = new boolean[101];
	public static int[] dr = {1, 1, -1, -1};
	public static int[] dc = {1, -1, -1, 1};
	public static int ans;
	public static int start_r, start_c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder("");
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			ans = -1;
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) {
					matrix[i][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N-2;i++) {
				for(int k=1;k<N-1;k++) {

					start_r = i;
					start_c = k;
					
					visited = new boolean[101];
					recur(i, k, 0, 1);
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
    static void recur(int nr, int nc, int dir, int sum) {
        visited[matrix[nr][nc]]=true;
        // 방향 초과(0~3)
        if(dir>3) return;
        // 각 방향에 따른 좌표 변화
        nr += dr[dir];
        nc += dc[dir];
         
        //돌아서 원래 점으로 돌아옴
        if(nr==start_r && nc==start_c) {
            ans = Math.max(ans, sum);
            return;
        }
         
        // 가장 위에 찍힌 점보다 더 위에 올라갈 수 없음.(작을 수 없음)
        if(nr<start_r) return;
        if(nr<0 || nc<0 || nr> N-1|| nc>N-1) return;
         
        //이미 방문했던 디저트 가게라면 return
        if(visited[matrix[nr][nc]]) return;
         
        visited[matrix[nr][nc]]=true;
        recur(nr,nc,  dir, sum+1);
        recur(nr,nc,  dir+1, sum+1);
        visited[matrix[nr][nc]]=false;
    }//end recur 
}

