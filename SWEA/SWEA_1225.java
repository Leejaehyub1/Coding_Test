package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class SWEA_1225
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10;
		int N = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean end_flag = false;
		int num = 1;
		int temp = 0;
		
		
		/*
		여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		for(int test_case = 1; test_case <= T; test_case++){
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			N = sc.nextInt();
			sc.nextLine();
			for(int i=0;i<8;i++) {
				queue.add(sc.nextInt());
			}
			num = 1;
//			System.out.println(queue.toString());
			while(true) {
				temp = (queue.poll()) - num;
				if(temp <= 0) {
					temp = 0;
					queue.offer(temp);
					break;
				}
				else{
					queue.offer(temp);
					num++;
					if(num == 6) {
						num = 1;
					}
				}
			}
			System.out.printf("#%d ", test_case);
			while(!queue.isEmpty()) {
				System.out.printf("%d ",queue.poll());
			}
			System.out.println();
		}
	}
}
