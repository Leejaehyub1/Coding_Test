package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1003 {
	
//	public static int calculate(int N) {
//		if(N== 0) {
//			zero_count++;
//			return 0;
//		}
//		else if(N==1) {
//			one_count++;
//			return 1;
//		}
//		else {
//			return calculate(N-1) + calculate(N-2);
//		}
//		
//	}
	
	static ArrayList<Integer> zero_count;
	static ArrayList<Integer> one_count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int T=0; T<test_case; T++) {
			int num = Integer.parseInt(br.readLine());
			zero_count = new ArrayList<Integer>();
			one_count = new ArrayList<Integer>();
			for(int i=0; i<=num; i++) {
				if(i==0) {
					zero_count.add(1);
					one_count.add(0);
					continue;
				}
				if(i==1) {
					zero_count.add(0);
					one_count.add(1);
				}
				else {
					zero_count.add(zero_count.get(i-2)+zero_count.get(i-1));
					one_count.add(one_count.get(i-2)+one_count.get(i-1));
				}
			}
			if(num==0) {
				System.out.println("1 0");
			}
			else if(num==1) {
				System.out.println("0 1");
			}
			else {
				System.out.println(zero_count.get(num) + " " + one_count.get(num));
			}

		}
		

		
			
	}
}
