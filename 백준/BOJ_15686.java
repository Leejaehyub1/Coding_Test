package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
	static int N, M;
	static int[] choose;
	static int ans = Integer.MAX_VALUE;
	static ArrayList<int []> houseList = new ArrayList<int []>();
	static ArrayList<int []> chickenList = new ArrayList<int []>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		choose = new int[M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					houseList.add(new int[] {i,k});
				}
				else if(temp == 2){
					chickenList.add(new int[] {i,k});
				}
			}
		}
		combination(0, 0);
		System.out.println(ans);
	}
	public static void combination(int cnt, int start) {
		if(cnt == M) {
			int total_distance = 0;
			for(int i=0; i<houseList.size();i++) {
				int single_distance = Integer.MAX_VALUE;
				for(int k=0; k<M;k++) {
					int temp = Math.abs(houseList.get(i)[0] - chickenList.get(choose[k])[0])
								+ Math.abs(houseList.get(i)[1] - chickenList.get(choose[k])[1]);
					single_distance = Math.min(single_distance, temp);
				}
				total_distance += single_distance;
			}
			ans = Math.min(ans, total_distance);
			return;
		}
		for(int i=start; i<chickenList.size();i++) {
			choose[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
}
