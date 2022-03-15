package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Stick[] list = new Stick[N];
		int max_index = 0;
		int ans = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			list[i] = new Stick(x, height);
		}
		
		
		Arrays.sort(list);
		for(int i=0;i<N;i++) {
			if(list[max_index].height < list[i].height) {
				max_index = i;
			}
		}
		int temp_index = 0;
		for(int i=1;i<=max_index;i++) {
			if(list[temp_index].height <= list[i].height) {
				ans += (list[i].x - list[temp_index].x)*list[temp_index].height;
				temp_index = i;
			}
		}
//		System.out.println(ans);
		temp_index = N-1;
		for(int i=N-2;max_index<=i;i--) {
			if(list[temp_index].height <= list[i].height) {
				ans += (list[temp_index].x - list[i].x)*list[temp_index].height;
				temp_index = i;
			}
		}
		ans += list[max_index].height;
		System.out.println(ans);

//		Arrays.sort(list);
		
//		int previous_x = list[0].x;
//		int current_height = list[0].height;
//		int ans = 0;
//		for(int i=1; i<N-1;i++) {
//			if(current_height <= list[i].height) {
//				ans += (list[i].x - previous_x) * current_height;  
//			}
//		}
	}
}
class Stick implements Comparable<Stick>{
	int x;
	int height;
	
	public Stick(int x, int height) {
		super();
		this.x = x;
		this.height = height;
	}

	@Override
	public int compareTo(Stick s) {
		return this.x-s.x;
	}
}
