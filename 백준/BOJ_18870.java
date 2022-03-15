package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_18870 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] arr = new int [N];
		HashSet<Integer> mySet = new HashSet<Integer>();
		HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
		
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			mySet.add(arr[i]);
		}
		int count = 0;
		int [] temp = new int[mySet.size()];
		for(int i : mySet) {
			temp[count++] = i;
		}
		Arrays.sort(temp);
		for(int i=0;i<temp.length;i++) {
			index.put(temp[i],i);
		}
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<N;i++) {
			sb.append(index.get(arr[i])).append(" ");
		}
		sb.append("\n");
		System.out.println(sb);

	}

}
