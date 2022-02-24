package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2116 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int [] matchList = {5, 3, 4, 1, 2, 0};	//서로 대응되는 index
		int max = -1;
		int N = Integer.parseInt(br.readLine());
		int[][] dialList = new int[N][6];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<6;k++) {
				dialList[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<6;i++) {
			int bottom_value = dialList[0][i];
			int top_value = dialList[0][matchList[i]];
			int previous_bottom, bottom_index=0;
			int sum = dialMax(bottom_value, top_value);
			System.out.printf("bottom_value=%d top_value=%d sum=%d\n",bottom_value, top_value, sum );
			for(int k=1;k<N;k++) {
				previous_bottom = bottom_value;
				bottom_value = top_value;
				for(int m=0;m<6;m++) {
					if(dialList[k][m] == top_value) {
						bottom_index = m;
						break;
					}
				}
				top_value = dialList[k][matchList[bottom_index]];
				sum += dialMax(bottom_value, top_value);
				System.out.printf("bottom_value=%d top_value=%d dialMax=%d\n",bottom_value, top_value, dialMax(bottom_value, top_value) );
			}
			max = Math.max(max,  sum);
			System.out.println();
		}
		System.out.println(max);
	}
	static int dialMax(int a, int b) {
		if(a!=6 && b!=6) {
			return 6;
		}
		else {
			if(a!=5 && b!=5) {
				return 5;
			}
			else {
				return 4;
			}
		}
	}


}
