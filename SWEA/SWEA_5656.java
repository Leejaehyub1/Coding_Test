package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5656 {
	static int N, W, H;
	static int[][] matrix;
	static int[][] temp;
	static int[] num;
	
	static int remainBlock;
	static int startBlock;
	static int answer;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			matrix = new int[H][W];
			temp = new int[H][W];
			num = new int[N];
			
			startBlock = 0;
			answer = Integer.MAX_VALUE;
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<W;k++) {
					matrix[i][k] = Integer.parseInt(st.nextToken());
					if(matrix[i][k] != 0) {
						startBlock++;
					}
				}
			}
			Permutation(0);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
//			for(int i=0;i<H;i++) {
//				for(int k=0;k<W;k++) {
//					temp[i][k] = matrix[i][k];
//				}
//			}
//			Crash(2);
//			pushDown();
//			Print();
//			System.out.println();
//			Crash(2);
//			pushDown();
//			Print();
//			System.out.println();
//			Crash(6);
//			pushDown();
//			Print();
//			System.out.println();
		}
		System.out.println(sb);
//		for(int c:num) {
//			if(temp[H-1][c] == 0)	continue;
//			Crash(c);
//			pushDown();
//		}
//		
//		answer = Math.min(answer, remainBlock);
//		if(answer == 0)	return;

		
	}
	static Queue<int[]> queue = new LinkedList<int[]>();
	public static void Crash(int x) {
		int r = 0;
		int c = x;
//		System.out.println("r="+r+"c="+c);
		while( r<H && temp[r][c]==0) {
			r++;
		}
		if(r == H)	return;
		int power = temp[r][c]-1;
		queue.add(new int[] {r,c,power});
		temp[r][c] = 0;
		remainBlock--;
		
		while(!queue.isEmpty() && remainBlock>=0) {
			int[] arr = queue.poll();
			r = arr[0];
			c = arr[1];
			power = arr[2];
//			System.out.println("r="+r+" c="+c);
			if(0<power) {
				for(int i=1;i<=power;i++) {
					//아래로 퍼진다
					int nr = r+i;
					int nc = c;
					if(0<=nr && nr<H && 0<=nc && nc<W && temp[nr][nc]!=0) {	
						queue.add(new int[] {nr, nc, temp[nr][nc]-1});
						remainBlock--;
						temp[nr][nc] = 0;
					}
					
					//위로 퍼진다
					nr = r-i;
					if(0<=nr && nr<H && 0<=nc && nc<W && temp[nr][nc]!=0) {	
						queue.add(new int[] {nr, nc, temp[nr][nc]-1});
						remainBlock--;
						temp[nr][nc] = 0;
					}
					
					// 오른쪽으로 퍼진다
					nr = r;
					nc = c+i;
					if(0<=nr && nr<H && 0<=nc && nc<W && temp[nr][nc]!=0) {
						queue.add(new int[] {nr, nc, temp[nr][nc]-1});
						remainBlock--;
						temp[nr][nc] = 0;
					}
					
					// 왼쪽으로 퍼진다
					nr = r;
					nc = c-i;
					if(0<=nr && nr<H && 0<=nc && nc<W && temp[nr][nc]!=0) {
						queue.add(new int[] {nr, nc, temp[nr][nc]-1});
						remainBlock--;
						temp[nr][nc] = 0;
					}
				}
			}
			
		}	
	}
	public static void pushDown() {
		Stack<Integer> stack = new Stack<Integer>();
		for(int k=0;k<W;k++) {
			for(int i=0;i<H;i++) {
				if(temp[i][k] != 0) {
					stack.add(temp[i][k]);
					temp[i][k] = 0;
				}
			}
			int cnt = 1;
			while(!stack.isEmpty()) {
				temp[H-cnt][k] = stack.pop();
				cnt++;
			}
		}
	}
	
	public static void Permutation(int cnt) {
		if(cnt == N) {
//			if(!(num[0]==0 && num[1]==1 && num[2]==2))	return;
			remainBlock = startBlock;
			for(int i=0;i<H;i++) {
				for(int k=0;k<W;k++) {
					temp[i][k] = matrix[i][k];
				}
			}
			
			for(int c:num) {
//				if(temp[H-1][c] == 0)	continue;
				Crash(c);
				pushDown();
//				Print();
//				System.out.println();
			}
			
			answer = Math.min(answer, remainBlock);
			return;
		}
		if(answer == 0)	return;
		for(int i=0;i<W;i++) {
			num[cnt] = i;
			Permutation(cnt+1);
		}
		return;
	}
	public static void Print() {
		for(int i=0;i<H;i++) {
			System.out.println(Arrays.toString(temp[i]));
		}
	}
}
