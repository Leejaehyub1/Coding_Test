package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2628 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> garo = new ArrayList<Integer>();
		ArrayList<Integer> sero = new ArrayList<Integer>();

		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == 1) {
				garo.add(b);
			}
			else {
				sero.add(b);
			}
		}
		int max = -1;
		int temp;
		garo.add(0,0);
		garo.add(W);
		sero.add(0,0);
		sero.add(H);
		Collections.sort(garo);
		Collections.sort(sero);

		for(int i=0; i<garo.size()-1;i++) {
			for(int k=0;k<sero.size()-1;k++) {
				temp = (garo.get(i+1)-garo.get(i)) * (sero.get(k+1)-sero.get(k));
				max = Math.max(max, (garo.get(i+1)-garo.get(i))*(sero.get(k+1)-sero.get(k)));
//				System.out.printf("%d %d %d %d %d\n",garo.get(i+1), garo.get(i), sero.get(k+1), sero.get(k), temp);
			}
		}
//		System.out.println();
//		for(int i=0;i<garo.size();i++) {
//			System.out.print(garo.get(i)+" ");
//		}
//		System.out.println();
//		for(int i=0;i<sero.size();i++) {
//			System.out.print(sero.get(i)+" ");
//		}
//		System.out.println();
		System.out.println(max);
	}

}
