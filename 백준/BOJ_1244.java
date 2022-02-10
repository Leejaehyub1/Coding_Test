package algorithm;
import java.util.Scanner;

public class BOJ_1244 {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt();
		int [] arr = new int[N];
		sc.nextLine();
		String [] arr_temp = sc.nextLine().split(" ");
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(arr_temp[i]);
		}
		int student_num = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<student_num;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			b--;
//			System.out.printf("%d %d\n", a,b);
			if(a==1) {
				//b의 배수의 스위치 반대로
//				System.out.printf("남자, %d\n",b);
				for(int k=b; k<N; k=k+(b+1)) {
					arr[k] = (arr[k]+1)%2;
				}
			}
			else {
				arr[b] = (arr[b]+1)%2;
//				System.out.println("여자");
				for(int d=1; 0<=(b-d) && (b+d)<N; d++) {
					if(arr[b-d] == arr[b+d]) {
						arr[b-d] = (arr[b-d]+1)%2;
						arr[b+d] = (arr[b+d]+1)%2;
					}
					else {
						break;
					}
				}
			}
		}
		for(int q=0;q<N;q++) {
			System.out.print(arr[q]);
			if(q!=0 && (q%20)==19) {
				System.out.println();
			}
			else {
				System.out.print(" ");
			}
		}
	}

}
