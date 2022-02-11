package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<int[]>(); //Stack에 int형 배열 저장 가능!!
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<num; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek()[0] < n) 
					stack.pop();
				else { 
					System.out.print(stack.peek()[1] + " ");
					break;
				}
			}
			
			if(stack.isEmpty()) 
				System.out.print("0 ");
			stack.push(new int[] {n, i+1}); 
		}
			
	}
}
