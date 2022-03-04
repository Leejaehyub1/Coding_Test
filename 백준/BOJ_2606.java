package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
	static boolean[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		arr = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = true;
			arr[b][a] = true;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1] = true;
		int ans = 0;
		while(!queue.isEmpty()) {
			int r = queue.poll();
//			visited[r] = true;
//			System.out.println(r);
//			System.out.println(Arrays.toString(visited));
			ans += 1;
			for(int i=1;i<=N;i++) {
				if(arr[r][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
//					System.out.println(i);
					
				}
			}
		}
		System.out.println(ans-1);
	}

}
