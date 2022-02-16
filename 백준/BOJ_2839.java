package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int N = Integer.parseInt(br.readLine());
		int ans = -1;
		int five_max = N/5;
		for(int i=five_max;0<=i;i--) {
			int temp = N-(5*i);
			if(temp%3==0) {
				ans = i + temp/3;
				break;
			}
		}
		sb.append(ans);
		System.out.println(sb);
		//5a + 3b = 72
		//a=14부터 시작 점점 감소 5a+3b = 72 가 되는 b가 존재하면 끝 그게 정답.
		//temp = 72-5a 가 3으로 나누어 떨어지면 
	}

}
