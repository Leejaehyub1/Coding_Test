package algorithm;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1208 {
	public static void main(String[] args) {
	    // TODO Auto-generated method stub
	    Scanner sc = new Scanner(System.in);
	    int test_case = 1;

	    for (int x = 1; x <= test_case; x++) {
	        int dump = sc.nextInt();
	        int[] arr = new int[100];
	        int max = Integer.MIN_VALUE;
	        int min = Integer.MAX_VALUE;

	        for (int i = 0; i < 100; i++) {
	            arr[i] = sc.nextInt();
	        }

	        while (dump != 0) {
	            int idxI = -1, idxA = -1;
	            max = Integer.MIN_VALUE;
	            min = Integer.MAX_VALUE;
	            
	            for (int i = 0; i < 100; i++) {
	                if (arr[i] > max) {
	                    max = arr[i];
	                    idxA = i;
	                }
	                if (arr[i] < min) {
	                    min = arr[i];
	                    idxI = i;
	                }
	            }
	            if (max - min <= 1)
	                break;

	            arr[idxA] -= 1;
	            arr[idxI] += 1;
	            
	            dump--;
	            System.out.println(dump);
	        }
	        for (int i = 0; i < 100; i++) {
	            if (arr[i] > max) {
	                max = arr[i];
	            }
	            if (arr[i] < min) {
	                min = arr[i];
	            }
	        }
	        System.out.println("#" + x + " " + (max-min));
	    }
	}
}
//	public static void main(String args[]) throws Exception
//	{
//		/*
//		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
//		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
//		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
//		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
//		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
//		 */
//		//System.setIn(new FileInputStream("res/input.txt"));
//
//		/*
//		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
//		 */
//		Scanner sc = new Scanner(System.in);
//		int T = 10;
//		/*
//		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
//		*/
//		int N = 100;
//		int [] arr = new int[N];
//		for(int test_case = 1; test_case <= T; test_case++)
//		{
//		
//			/////////////////////////////////////////////////////////////////////////////////////////////
//			int limit = sc.nextInt();
//			int max_index = 0;
//			int min_index = 0;
//			sc.nextLine();
//			for(int i=0; i<N;i++) {
//				arr[i] = sc.nextInt();
//			}
//			sc.nextLine();
//			
//			for(int i=0; i<limit;i++) {
//				for(int k=0;k<N;k++) {
//					if(arr[max_index] < arr[k]) {
//						max_index = k;
//					}
//					if(arr[k] < arr[min_index]) {
//						min_index = k;
//					}
//					
//				}
//				arr[min_index]++;
//				arr[max_index]--;
//			}
//			for(int k=0;k<N;k++) {
//				if(arr[max_index] < arr[k]) {
//					max_index = k;
//				}
//				if(arr[k] < arr[min_index]) {
//					min_index = k;
//				}
//				
//			}
//			System.out.println("#"+test_case + " "+(arr[max_index]-arr[min_index]));
//			/////////////////////////////////////////////////////////////////////////////////////////////
//
//		}
//	}
//}
