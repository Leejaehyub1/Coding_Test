package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int len = Math.max(N, K) + 1;
		len = 100001;	//왜?
		int [] arr = new int[100001];
		arr[N] = 1;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
//		System.out.println(queue);
		if(N == K) {
			System.out.println("0");
		}
		else {
			int ans = 0;
			while(!queue.isEmpty()) {
				int temp = queue.poll();
				int next;
				next = temp+1;
				if(next == K) {
					System.out.println(arr[temp]);
					break;
				}
				if(0<=next && next<len && arr[next] == 0){
					queue.add(next);
					arr[next] = arr[temp]+1;
				}
				next = temp-1;
				if(next == K) {
					System.out.println(arr[temp]);
					break;
				}
				if(0<=next && next<len && arr[next] == 0){
					queue.add(next);
					arr[next] = arr[temp]+1;
				}
				next = 2*temp;
				if(next == K) {
					System.out.println(arr[temp]);
					break;
				}
				if(0<=next && next<len && arr[next] == 0){
					queue.add(next);
					arr[next] = arr[temp]+1;
				}
				
				
			}
//			System.out.println(ans-1);
		}
		
		

	}

}
