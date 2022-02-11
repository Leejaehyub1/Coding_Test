package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class SWEA_9229
{
	static int ans = -1;
	static int N = 0;
	static int M = 0;
	static int [] weight;
	public static void main(String args[]) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=0;
		T=Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			ans = -1;
			st  = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st  = new StringTokenizer(br.readLine(), " ");
			weight = new int[N];
			for(int i=0;i<N;i++) {
				weight[i] = Integer.parseInt(st.nextToken());
//				System.out.println(weight[i]);
			}
			combination(0, 0, 0);
			System.out.printf("#%d %d\n",test_case,ans);
			
		}
	}
	public static void combination(int cnt, int start, int sum) {
		if(cnt == 2) {
			if(sum <= M) {
				ans = Math.max(ans, sum);
			}
			return;
		}
		for(int i=start; i<N; i++) {
			combination(cnt+1, i+1, sum + weight[i]);
		}
	}
}