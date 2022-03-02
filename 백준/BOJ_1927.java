package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder("");
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int value = Integer.parseInt(br.readLine());
			if(value == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(pq.poll()).append("\n");
				}
			}
			else {
				pq.add(value);
			}
		}
		System.out.println(sb);
	}

}
