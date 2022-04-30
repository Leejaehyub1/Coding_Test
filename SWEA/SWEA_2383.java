package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_2383 {
	static int N, M;
	static int S;
	static int[] num;
	static int min;
	
	static Point[] man;
	static Point[] stair;
	static int[] length;
	static int answer;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder("");
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			M = 0;
			S = 0;
			
			man = new Point[10];
			stair = new Point[2];
			length = new int[2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp == 1) {
						man[M++] = new Point(i, k);
					}
					else if(temp != 0) {
						stair[S] = new Point(i,k);
						length[S++] = temp;
					}
				}
			}
			
			answer = Integer.MAX_VALUE;
			num = new int[M];
			Permutation(0);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);

	}
	public static int Calculate() {
		PriorityQueue<Integer> pq0 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		
		for(int i=0;i<M;i++) {
			if(num[i] == 0) {
				pq0.add(Math.abs(man[i].r - stair[0].r)+Math.abs(man[i].c - stair[0].c));
			}
			else{
				pq1.add(Math.abs(man[i].r - stair[1].r)+Math.abs(man[i].c - stair[1].c));
			}
		}
		
		int man = M;
		int time = 0;
		int[] stair0 = new int[3];
		int[] stair1 = new int[3];
		while(true) {
			if(man == 0) {
				boolean flag = true;
				for(int i=0;i<3;i++) {
					if(stair0[i] != 0) {
						flag = false;
						break;
					}
					if(stair1[i] != 0) {
						flag = false;
						break;
					}
				}
				if(flag)	break;
			}
			
			for(int i=0;i<3;i++) {
				if(stair0[i] == 0) {
					if(!pq0.isEmpty() && pq0.peek() <= time) {
						stair0[i] = length[0];
						man--;
						pq0.poll();
					}
				}
				else {
					stair0[i]--;
					if(stair0[i] == 0) {
						if(!pq0.isEmpty() && pq0.peek() <= time) {
							stair0[i] = length[0];
							man--;
							pq0.poll();
						}
					}
				}
				
				if(stair1[i] == 0) {
					if(!pq1.isEmpty() && pq1.peek() <= time) {
						stair1[i] = length[1];
						man--;
						pq1.poll();
					}
				}
				else {
					stair1[i]--;
					if(stair1[i] == 0) {
						if(!pq1.isEmpty() && pq1.peek() <= time) {
							stair1[i] = length[1];
							man--;
							pq1.poll();
						}
					}
				}
			}
			time++;
		}
		return time;
	}
	
	public static void Permutation(int cnt) {
		if(cnt == M) {
			answer = Math.min(answer,  Calculate());
			return;
		}
		
		num[cnt] = 0;
		Permutation(cnt+1);
		num[cnt] = 1;
		Permutation(cnt+1);
	}
	
	
	public static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
}
