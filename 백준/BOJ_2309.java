package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//public class BOJ_2309 {
//	static int [] arr = new int[10];
////	static boolean [] isSelected = new boolean[9];
//	static int [] num = new int[7];
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		
//		for(int i=0;i<9;i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		
//		comb(0, 0);
//	}
//	public static void comb(int cnt, int start) {
//		if(cnt == 7) {
//			int sum = 0;
//			for(int i=0;i<7;i++) {
//				sum += num[i];
//			}
//			if(sum == 100) {
//				Arrays.sort(num);
//				for(int i=0;i<7;i++) {
//					System.out.println(num[i]);
//				}
//			}
//			return;
//		}
//		
//		for(int i=start; i<9; i++) {
//			
//			num[cnt] = arr[i];
//			comb(cnt+1, i+1);
//		}
//		
//	}
//
//}
