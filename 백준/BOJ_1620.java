package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, String> hash = new HashMap<Integer, String>();
		HashMap<String, Integer> hash_2 = new HashMap<String, Integer>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++) {
			String temp = br.readLine();
			hash.put(i, temp);
			hash_2.put(temp,i);
		}
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<M;i++) {
			String temp = br.readLine();
			if('0' <= temp.charAt(0) && temp.charAt(0) <='9') {
//				System.out.println(hash.get(Integer.parseInt(temp)));
				sb.append(hash.get(Integer.parseInt(temp))).append("\n");
			}
			else {
				sb.append(hash_2.get(temp)).append("\n");
			}
		}
		System.out.println(sb);

	}

}
