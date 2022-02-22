package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int big_x = 0;
		int big_y = 0;
		int small_x = 0;
		int small_y = 0;
		int [] arr = new int[6];
		for(int i=0; i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<3;i++) {
			big_x = Math.max(big_x, arr[2*i]);
			big_y = Math.max(big_y, arr[2*i+1]);
		}
		for(int i=0; i<6;i++) {
			if(i%2 == 0) {
				if(big_y == (arr[(i+1)%6]+arr[(i+5)%6])){
					small_y = arr[i];
				}
			}
			else {
				if(big_x == arr[(i+1)%6]+arr[(i+5)%6]) {
					small_x = arr[i];
				}
			}
		}
		System.out.println(big_x*big_y);
		System.out.println((small_x*small_y));
		System.out.println((big_x*big_y - (small_x*small_y))*N);
		

	}

}
