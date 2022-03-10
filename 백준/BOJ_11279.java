package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder("");
		for(int tc=0;tc<test_case;tc++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				if(heap.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(heap.poll()).append("\n");
				}
			}
			else {
				heap.add(N);
			}
//			System.out.println(sb);
		}
		System.out.println(sb);

	}

}
