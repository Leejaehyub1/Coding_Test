package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int [] dx = {-1, 1, 0, 0};
		int [] dy = {0, 0, -1, 1};
		
		for(int test_case=0; test_case<T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());	//가로 길이
			int N = Integer.parseInt(st.nextToken());	//세로 길이
			int K = Integer.parseInt(st.nextToken());	//배추의 수
			Stack <int[]> stack = new Stack<int[]>();
			int count = 0;
			boolean [][] map = new boolean[N][M];
			boolean [][] visited = new boolean[N][M];
			int [][] visited_int = new int[N][M];
			for(int a=0; a<K;a++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}
//			for(int r=0; r<N;r++) {
//				for(int c=0;c<M;c++) {
//					System.out.print(map[r][c]+"\t");
//				}
//				System.out.println();
//			}
			for(int y=0; y<N;y++) {
				for(int x=0;x<M;x++) {
					if(map[y][x] && !visited[y][x]) {
						count++;
						stack.add(new int[] {y,x});
						visited[y][x] = true;
						visited_int[y][x] = count; 
						int [] temp;
						while(!stack.isEmpty()) {
							temp = stack.pop();
							int r = temp[0];
							int c = temp[1];
							for(int i=0; i<4;i++) {
								int nx = c + dx[i];
								int ny = r + dy[i];
								if(0<=nx && nx<M && 0<=ny && ny<N) {
									if(map[ny][nx] && !visited[ny][nx]) {
										visited[ny][nx] = true;
										visited_int[ny][nx] = count;
										stack.add(new int[] {ny,nx});
									}
								}
							}
						}
					}
				}
			}
//			for(int r=0; r<N;r++) {
//				for(int c=0;c<M;c++) {
//					System.out.print(visited_int[r][c]+"\t");
//				}
//				System.out.println();
//			}
			System.out.println(count);
			
		}

	}

}
