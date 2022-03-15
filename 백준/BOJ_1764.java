package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1764 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String, Boolean> h1 = new HashMap<String, Boolean>();
		ArrayList<String> arr = new ArrayList<String>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			h1.put(temp, true);
		}
		for(int i=0;i<M;i++) {
			String temp = br.readLine();
			if(h1.containsKey(temp)) {
				arr.add(temp);
			}
		}
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder("");
		sb.append(arr.size());
		sb.append("\n");
		for(int i=0;i<arr.size();i++) {
			sb.append(arr.get(i)).append("\n");
		}
		System.out.println(sb);
		

	}

}
