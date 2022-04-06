package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_2577 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//초밥 벨트의 접시 수
		int D = Integer.parseInt(st.nextToken());	//초밥의 가짓수
		int K = Integer.parseInt(st.nextToken());	//연속해서 먹는 접시의 수
		int C = Integer.parseInt(st.nextToken());	//쿠폰 번호
		
		int[] belt = new int[N];
		int[] visited = new int[D+1];
		for(int i=0;i<N;i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		int kind = 0;
		int answer = 0;
		
		for(int i=0;i<K;i++) {
			if(visited[belt[i]] == 0)	kind++;
			visited[belt[i]]++;
		}
		answer = kind;
		
		for(int i=1; i<N;i++) {
			if(answer <= kind) {
				if(visited[C] == 0) {
					answer = kind+1;
				}
				else {
					answer = kind;
				}
			}
			
			if(visited[belt[i-1]] == 1)	kind--;
			visited[belt[i-1]]--;
			
			if(visited[belt[(i+K-1)%N]] == 0)	kind++;
			visited[belt[(i+K-1)%N]]++;
		}
		
		System.out.println(max);

	}

}
