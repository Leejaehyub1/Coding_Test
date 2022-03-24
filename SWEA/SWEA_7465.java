package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7465 {

	static int P;
	static int[] parents;
	public static void makeSet() {
		parents = new int[P];
		
		for (int i = 0; i < P; i++) {
			parents[i]=i;
		}
	}
	public static int findSet(int a) {
		if(a == parents[a])	return a;
		return parents[a] = findSet(parents[a]);
	}
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot)	return false;
		parents[bRoot] = aRoot;	return true;
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			makeSet();
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a-1,b-1);
				
			}
			int ans = 0;
			for(int k=0; k<P; k++) {
				if(k == parents[k])	ans++;
			}
			StringBuilder sb = new StringBuilder("");
			sb.append("#").append(test_case).append(" ").append(ans);
			System.out.println(sb);
		}
		
		

	}

}
