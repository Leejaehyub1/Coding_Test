package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005 {
	static int num_building;
	static int num_rule;
	static int [] cost_only;
	static int [] in_degree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int x, y;
		for(int test_case=0;test_case<T;test_case++) {
			st = new StringTokenizer(br.readLine());
			num_building = Integer.parseInt(st.nextToken());
			num_rule = Integer.parseInt(st.nextToken());
			
			List<List<Integer>> arr = new ArrayList<List<Integer>>();
			cost_only = new int[num_building+1];
			in_degree = new int[num_building+1];
			
			st = new StringTokenizer(br.readLine());
			arr.add(new ArrayList<Integer>());
			for(int i=1;i<=num_building;i++) {
				arr.add(new ArrayList<Integer>());
				cost_only[i] = Integer.parseInt(st.nextToken());
			}
//			for(int i=0;i<num_building;i++) {
//				System.out.println(cost_only[i]);
//			}
			
			
			for(int i=0; i<num_rule;i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				arr.get(x).add(y);
				in_degree[y]++;
			}
//			for(int i=0;i<=num_building;i++) {
//				for(int k=0; k<arr.get(i).size();k++) {
//					System.out.print(arr.get(i).get(k)+" ");
//				}
//				System.out.println();
//			}
			int target = Integer.parseInt(br.readLine());
			calculate(arr, target);
		}
	}
	public static void calculate(List<List<Integer>> arr, int target) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int [] cost_total = new int[num_building+1];
		for(int i=1;i<=num_building;i++) {
			cost_total[i] = cost_only[i];
			if(in_degree[i] == 0) {
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(Integer i : arr.get(current)){
				cost_total[i] = Math.max(cost_total[i], cost_total[current] + cost_only[i]);
				in_degree[i]--;
				if(in_degree[i]==0) {
					queue.offer(i);
				}
				
			}
		}
//		System.out.println("asdfadsf");
//		System.out.println(Arrays.toString(cost_only));
		System.out.println((cost_total[target]));
	}

}
