package algorithm;

import java.util.Scanner;

public class BOJ_1074 {
	static int N;
	static int r;
	static int c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		System.out.println(calculate(N,r,c));
	}
	public static int calculate(int N, int r, int c) {
		int size = (int)Math.pow(2, N);
		if(N==1) {
			return (2*r + c);
		}
		if(r < size/2) {
			if(c< size/2) {
				return calculate(N-1, r, c);
			}
			else {
				return (size*size)/4 + calculate(N-1, r, c-(size/2));
			}
		}
		else {
			if(c<size/2) {
				return size*size/2 + calculate(N-1, r-(size/2), c);
			}
			else {
				return ((size*size)/4)*3 + calculate(N-1, r-(size/2), c-(size/2));
			}
		}
	}
	public static int power(int N) {
		int ans = 1;
		for(int i=1; i<=N;i++) {
			ans *= 2;
		}
		return ans;
	}
	public static int previous(int N) {
		return power(N-1);
	}
}
