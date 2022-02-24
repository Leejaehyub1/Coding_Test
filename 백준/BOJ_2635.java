package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2635 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max_start = 0;
		int max_len = -1;
		
		int now, past, temp;
		int count;

		for(int i=1; i<=N; i++) {
			now = i;
			past = N;
			count = 2;
			while(past - now >= 0) {
				temp = now;
				now = past - now;
				past = temp;
				count ++;
			}
			if(max_len < count) {
				max_start = i;
				max_len = count;
			}
		}
		now = max_start;
		past = N;
		StringBuilder sb = new StringBuilder("");
		sb.append(N).append(" ");
		while(past - now >= 0) {
			sb.append(now).append(" ");
			temp = now;
			now = past - now;
			past = temp;
		}
		sb.append(now);
		System.out.println(max_len);
		System.out.println(sb);

	}

}
