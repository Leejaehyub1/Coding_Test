package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean [][] visited = new boolean[100][100];
		int ans = 0;
		int x1,x2,y1,y2;
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(int k=x1; k<x2;k++) {
				for(int q=y1; q<y2;q++) {
					if(!visited[k][q]) {
						visited[k][q] = true;
						ans++;
					}
				}
			}
//			System.out.printf("%d %d %d %d\n",x1,y1,x2,y2);
		}
//			for(int i=0; i<10; i++) {
//				for(int k=0;k<10;k++) {
//					System.out.print(visited[i][k]+" ");
//				}
//				System.out.println();
//			}
		System.out.println(ans);
	}

}
