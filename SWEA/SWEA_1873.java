package algorithm;
import java.util.*;
public class SWEA_1873 {
	
	public static void main(String args[]) throws Exception{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		int current_x=-1, current_y=-1;
		int H, W;
		char current_dir = '^';
//		HashMap<String, String> tank_dir = new HashMap<>();
		char [] tank_dir = {'^', 'v', '<', '>'};
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			H=sc.nextInt();
			W=sc.nextInt();
			sc.nextLine();
			char [][] arr = new char[H][W];
			for(int i=0;i<H;i++) {
				String temp_line = sc.nextLine();
				for(int k=0;k<W;k++) {
					char temp = temp_line.charAt(k);
					arr[i][k] = temp;
					if(temp == '>'|| temp =='<'|| temp =='^'|| temp =='v') {
						current_x = i;
						current_y = k;
						current_dir = temp;
					}
				}
			}
//			for(int i=0;i<H;i++) {
//				
//				for(int k=0;k<W;k++) {
//					System.out.printf("%c ", arr[i][k]);
//				}
//				System.out.println();
//			}
			int action_len = sc.nextInt();
			sc.nextLine();
			String action_list = sc.nextLine();
			for(int i=0;i<action_list.length();i++) {
				char action = action_list.charAt(i);
				switch(action) {
					case 'U':
						current_dir = tank_dir[0];
						arr[current_x][current_y] = '.';
						if(0<=current_x-1 && arr[current_x-1][current_y] == '.') {
							current_x--;
						}
						arr[current_x][current_y] = '^';
						break;
					case 'D':
						current_dir = tank_dir[1];
						arr[current_x][current_y] = '.';
						if(current_x+1<H 
								&& arr[current_x+1][current_y] == '.') {
							current_x++;
						}
						arr[current_x][current_y] = 'v';
						break;
					case 'L':
						current_dir = tank_dir[2];
						arr[current_x][current_y] = '.';
						if(0<=current_y-1 && arr[current_x][current_y-1] == '.') {
							current_y--;
						}
						arr[current_x][current_y] = '<';
						break;
					case 'R':
						current_dir = tank_dir[3];
						arr[current_x][current_y] = '.';
//						System.out.printf("%d %d\n", current_x, current_y);
//						System.out.printf("%c\n", arr[current_x][current_y+1]);

						if((current_y+1)<W && arr[current_x][current_y+1] == '.') {
							current_y++;
						}
						
//						System.out.printf("%d %d\n", current_x, current_y);
						arr[current_x][current_y] = '>';
						break;
					case 'S':
						int cannon_x=current_x;
						int cannon_y=current_y;
						while(0<=cannon_x && cannon_x<H && 0<=cannon_y&&cannon_y<W) {
							if(arr[cannon_x][cannon_y] == '*') {
								arr[cannon_x][cannon_y] = '.';
								break;
							}
							else if(arr[cannon_x][cannon_y] == '#') {
								break;
							}
							else{
								if(current_dir == '^') {
									cannon_x--;
//									System.out.println(cannon_x);
								}
								else if(current_dir == 'v') {
//									System.out.println("ads");
									cannon_x++;
								}
								else if(current_dir == '<') {
									
									cannon_y--;
//									System.out.printf("%d %d\n", cannon_x, cannon_y);
								}
								else {
									cannon_y++;
								}
								
							}
						}
						
						break;
					default:
						
					
				}
//				System.out.printf("%d %d\n", current_x, current_y);
				
			}
			
//			System.out.println(action);
			/////////////////////////////////////////////////////////////////////////////////////////////
			System.out.printf("#%d ", test_case);
			for(int i=0;i<H;i++) {
				for(int k=0;k<W;k++) {
					System.out.printf("%c", arr[i][k]);
				}
				System.out.println();
			}
		}
	}
}
