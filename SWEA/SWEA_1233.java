package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA_1233
{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		int N = 0;
		for(int test_case = 1; test_case <= T; test_case++){
			N = Integer.parseInt(br.readLine());
			int answer = 1;
			
			for(int i=1;i<=N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				char temp = st.nextToken().charAt(0);
				if(st.hasMoreTokens()) {
					if('0'<= temp && temp <= '9') {
						answer = 0;
					}
				}
				else {
					if(!('0'<= temp && temp <= '9')) {
						answer = 0;
					}
				}
			}
			System.out.printf("%d %d\n", test_case, answer);
		}
		
	}
}