package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {
	
	static int T= 10;
	static int num_input, start;
	static int[][] adjMatrix = new int[100][100];
	static int[] visited = new int[100];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			num_input = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			for(int i=0;i<100;i++) {
				Arrays.fill(adjMatrix[i], 0);
			}
			Arrays.fill(visited, 0);
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i< (num_input/2); i++) {
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				adjMatrix[from][to] = 1;
			}
			
			bfs(adjMatrix, start-1);
			int max_index = 0;
			for(int k=0;k<100;k++) {
				if(visited[max_index] <= visited[k]) {
					max_index = k;
				}
			}
			System.out.printf("#%d %d\n", test_case, max_index+1);
		}
//		System.out.println(sb.toString());
		
		
	}
	public static void bfs(int [][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = 1;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			//System.out.println(current);
			
			//current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for(int j = 0; j < 100; j++) {
				if(visited[j]==0 && adjMatrix[current][j] != 0) {
					queue.offer(j);
					visited[j] = visited[current]+1;
				}
			}
			
		}
	}
//	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
//		
//		//current : 현재 탐색 점
//		visited[current] = true;
//		sb.append(current+1).append(" ");
//		//System.out.println(current); //재귀를 타고올 때 마다 현재 정점이 됨
//		
//		// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
//		for(int j = 0; j < 100; j++) {
//			if(!visited[j] && adjMatrix[current][j] != 0) {
//				//if문에 만족하지 않으면 알아서 종료되므로 이 if문이 기저조건이 된다.
//				dfs(adjMatrix, visited, j);
//			}
//		}
//		
}
	
