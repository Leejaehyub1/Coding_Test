package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1767 {

	static int minLine;
	static int maxCore;
	static ArrayList<int[]> core;
	static int N;
	static int[][] map;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder("");
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			minLine = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			core = new ArrayList<int[]>(); 
			maxCore = 0;
			minLine = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i*j!=0 && i!=N-1 && j!=N-1 &&map[i][j] == 1) {
						core.add(new int[] {i,j});
					}
				}
			}
			dfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(minLine).append("\n");
		}
		System.out.println(sb);
		
		
	}
	
	public static void dfs(int coreCnt, int lineCnt, int index) {
//		System.out.println("cnt="+cnt+" sum="+sum);
//		print(map);
		if(index == core.size()) {
			if(maxCore < coreCnt ) {
				maxCore = coreCnt;
				minLine = lineCnt; 
			}
			if(maxCore == coreCnt) {
				minLine = Math.min(minLine,  lineCnt);
			}
			return;
		}


		for(int i = 0; i < 4; i++) {			
			int nr = core.get(index)[0];
			int nc = core.get(index)[1];

			int num = 0;
			while(true) {
				nr += delta[i][0];
				nc += delta[i][1];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
					break;
				}
				if(map[nr][nc] != 0) {
					num = 0;
					break;
				}
				num++;
			}
			
			if(num == 0) {
				dfs(coreCnt, lineCnt, index+1);
				continue;
			}
			else {
				nr = core.get(index)[0];
				nc = core.get(index)[1];
				for(int k=0;k<num;k++) {
					nr += delta[i][0];
					nc += delta[i][1];
					map[nr][nc] = 2;
				}
				
				dfs(coreCnt+1, lineCnt+num, index+1);
				
				nr = core.get(index)[0];
				nc = core.get(index)[1];
				for(int k=0;k<num;k++) {
					nr += delta[i][0];
					nc += delta[i][1];
					map[nr][nc] = 0;
				}
			}
			
			
		}
	}
	public static void print(int[][] temp) {
		for(int i=0;i<temp.length;i++) {
			System.out.println(Arrays.toString(temp[i]));
		}
	}

}
