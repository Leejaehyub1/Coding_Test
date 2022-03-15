package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10163 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int [][] map = new int[1001][1001];
		int N = Integer.parseInt(br.readLine());
		int [] area = new int[N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int a=0;a<W;a++) {
				for(int b=0;b<H;b++) {
					int value = map[x+a][y+b];
					area[value]--;
					map[x+a][y+b] = i;
					sum++;
				}
			}
			area[i] = sum;
		}
		for(int i=1;i<=N;i++) {
			System.out.println(area[i]);
		}

	}

}
