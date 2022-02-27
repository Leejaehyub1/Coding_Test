package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder("");
		if(M == 1) {
			M++;
		}
		else if(M==0) {
			M+=2;
		}
	
		for(int i=M;i<=N;i++) {
			boolean flag = true;
			for(int k=2; k*k<=i;k++) {
				if(i%k == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);

	}

}
