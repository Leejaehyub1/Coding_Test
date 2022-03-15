package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {
	static boolean [][] arr;
	static boolean[] visited;
	static boolean[] linked; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new boolean[N][N];
		visited = new boolean[N];
		linked = new boolean[N];
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			arr[r][c] = true;
			arr[c][r] = true;
			linked[r] = true;
			linked[c] = true;
		}
		int ans = 0;
		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(visited));
			if(!visited[i]) {
				visited[i] = true;
				ans++;
				queue.add(i);
				while(!queue.isEmpty()) {
					int r = queue.poll();
					for(int k=0; k<N;k++) {
						if(!visited[k] && arr[r][k]) {
							visited[k] = true;
							queue.add(k);
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
