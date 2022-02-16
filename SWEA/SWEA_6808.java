package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808 {
	static boolean [] isSelected_A = new boolean[19];
	static boolean [] isSelected_B = new boolean[9];
	static int [] num = new int[9];
	static int count_win;
	static int count_lose;

	static ArrayList<Integer> card_list_A;
	static ArrayList<Integer> card_list_B;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T;test_case++) {
			card_list_A = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=9;i++) {
				int temp = Integer.parseInt(st.nextToken());
				card_list_A.add(temp);
				isSelected_A[temp] = true;
			}
			card_list_B = new ArrayList<Integer>();
			Arrays.fill(num, 0);
			count_win = 0;
			count_lose = 0;
			for(int i=1;i<=18;i++) {
				if(!isSelected_A[i]) {
					card_list_B.add(i);
				}
				else {
					isSelected_A[i]=false;
				}
			}

			permutation(0);
			System.out.printf("#%d %d %d\n",test_case,count_win, count_lose);
		}

	}
	public static void permutation(int cnt) {
		if(cnt == 9) {
			int point_A = 0;
			int point_B = 0;
			for(int i=0;i<9;i++) {
				int card_A = card_list_A.get(i);
				int card_B = num[i];
				if( card_B < card_A) {
					point_A += (card_A+card_B);
				}
				else {
					point_B += (card_A+card_B);
				}
			}
			if(point_B < point_A) {
				count_win++;
			}
			else {
				count_lose++;
			}
			return;
		}
		for(int i=0;i<9;i++) {
			if(isSelected_B[i]) {
				continue;
			}
			isSelected_B[i] = true;
			num[cnt] = card_list_B.get(i);
			permutation(cnt+1);
			isSelected_B[i] = false;
		}
	}

}
