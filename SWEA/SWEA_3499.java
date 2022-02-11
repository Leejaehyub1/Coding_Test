package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499 {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();

			String [] s1 = new String[N+1];
			String [] s2 = new String[N+1];
			
			s1 = s.split(" ", N); //원래 문자열 배열

			boolean odd = (N%2==1)? true:false;
			int num = N/2;
			for(int i=0; i<num; i++) {
				s2[2*i] = s1[i];
				s2[2*i + 1] = s1[i + num+(odd?1:0)];
			}
			
			if(odd) {
				s2[(N-1)] = s1[(N)/2];
			}
			System.out.print("#"+test_case+" ");
			for(int i=0;i<N;i++) {
				System.out.print(s2[i]+" ");
			}
			System.out.println();


		}
	}
}
