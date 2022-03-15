package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		int N = Integer.parseInt(br.readLine());
		int num = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.equals("add")) {
				int temp = Integer.parseInt(st.nextToken());
				num = num | (1<<temp);				
//				System.out.println(Integer.toBinaryString(num));
			}
			else if(s.equals("check")) {
				int temp = Integer.parseInt(st.nextToken());
				sb.append((num >> temp) & 1).append("\n");
			}
			else if(s.equals("toggle")){
				int temp = Integer.parseInt(st.nextToken());
				num = num ^ (1 << temp);
			}
			else if(s.equals("remove")) {
				int temp = Integer.parseInt(st.nextToken());
				num = num & ~(1<<temp);
			}
			else if(s.equals("all")) {
				num = (1<<21)-1;
			}
			else if(s.equals("empty")) {
				num = 0;
			}
		}
		System.out.println(sb);

	}

}
