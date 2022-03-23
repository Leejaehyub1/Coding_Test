package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1541 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("-");
//		System.out.println(Arrays.toString(s));
		int ans = 0;
		for(int i=0;i<s.length;i++) {
			int sum = 0;
//			System.out.println(s[i]);
			String[] temp = s[i].split("\\+");
//			System.out.println(Arrays.toString(temp));
			for(int k=0;k<temp.length;k++) {
				sum += Integer.parseInt(temp[k]);
//				System.out.println(temp[k]);
			}
			
			if(i==0) {
				ans = sum;
			}
			else {
				ans -= sum;
			}
		}
		System.out.println(ans);
		

		

	}

}
