package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DisjointSetTest {

	static int N;
	static int[] parents;
	public static void makeSet() {
		parents = new int[N];
		
		for (int i = 0; i < N; i++) {
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
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		

	}

}
