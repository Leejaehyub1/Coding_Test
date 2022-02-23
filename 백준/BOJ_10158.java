package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		int t_p = (p+t)%(2*w);
		int t_q = (q+t)%(2*h);
		
		p = w - Math.abs(w-t_p);
		q = h - Math.abs(h-t_q);
		StringBuilder sb = new StringBuilder("");
		sb.append(p).append(" ").append(q);
		System.out.println(sb);
	}
	

}
