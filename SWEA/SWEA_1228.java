package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SWEA_1228
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int word_len;
		int command_len;
		int x;
		int y;
		int temp;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			word_len = sc.nextInt();
			for(int i=0;i<word_len;i++) {
				list.add(sc.nextInt());
			}
			sc.nextLine();
			command_len = sc.nextInt();
			sc.nextLine();
			for(int i=0;i<command_len;i++) {
				sc.next();	//I 입력
				x = sc.nextInt();
				y = sc.nextInt();

				for(int k=0; k < y; k++) {
					temp = sc.nextInt();
					list.add(x++,temp);

				}

			}
			System.out.print("#"+test_case+" ");
			for(int i=0; i < 10; i++) {
				if(list.isEmpty()) {
					break;
				}
				else {
					System.out.printf("%d ",list.poll());
				}
			}
			while(!list.isEmpty()) {
				list.poll();
			}

		}
	}
}