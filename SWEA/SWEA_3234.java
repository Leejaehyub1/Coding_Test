package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3234{
	public static int N, answer;
	public static int[] input;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			input = new int[N];
			for(int i = 0; i< N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			answer = 0;
			Arrays.sort(input);
			do { //부분집합
				subSet(0, 0, 0);
			
			}while(np());
			
			System.out.println("#"+testcase+" "+answer);
		}
		
		
	}
	
	public static void subSet(int cnt, int right, int left) {
		if(left >= right) {
			if(cnt == N) {
				answer++;
				return;
			}
			subSet(cnt+1, right+input[cnt], left);
			subSet(cnt+1, right, left + input[cnt]);
			
		}else {
			return;
		}

	}
	
	private static boolean np() { //np는 순열 횟수만큼 돈다.
		// 1. 교환위치 찾기
		int i = N-1;
		while(i > 0 && input[i-1] >= input[i]) --i;
		if(i == 0) return false;
		
		// 2. 교환위치에 교환할 값 찾기
		int j = N-1;
		while(input[i-1] >= input[j]) --j;
		
		// 3. 교환위치와 교환할 값 교환하기
		swap(i-1, j);
		
		// 4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성(오름차순정렬)
		int k = N-1;
		while(i < k) {
			swap(i++, k--);
		}
		return true;
	}
	
	public static void swap(int i , int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
