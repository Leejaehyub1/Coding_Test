package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0 ,-1};
	static int[][] arr;
	static boolean[] visited = new boolean[26];	//알파벳 개수
	static int answer;
	static int R;
	static int C;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int k=0;k<C;k++) {
				arr[i][k] = s.charAt(k) - 'A';
			}
		}
		dfs(0,0,0);
		StringBuilder sb = new StringBuilder("");
		sb.append(answer);
		System.out.println(sb);
		

	}
	public static void dfs(int x, int y, int count) {

		if(visited[arr[x][y]]) {
			answer = Math.max(answer,  count);
			return;
		}
		else {
			visited[arr[x][y]] = true;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
//				System.out.println(visited.toString());
				if(0<=nx && nx<R && 0<=ny && ny<C) {
					dfs(nx,ny,count+1);
				}
			}
			visited[arr[x][y]] = false;
		
		}
	}
	
}

