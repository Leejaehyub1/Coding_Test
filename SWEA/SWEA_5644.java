package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5644 {
	static int num_move;
	static int num_battery;
	static int [][] move;
	static battery [] battery_list;
	static int answer = 0;
	static int [] dx = {0, 0, 1, 0, -1};
	static int [] dy = {0, -1, 0, 1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			num_move = Integer.parseInt(st.nextToken());
			num_battery = Integer.parseInt(st.nextToken());
			
			move = new int[2][num_move];
			//사용자A,B의 이동정보 입력
			for(int i=0; i<2;i++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<num_move;k++) {
					move[i][k] = Integer.parseInt(st.nextToken());
				}
			}
			//AP의 정보 입력
			battery_list = new battery[num_battery];
			for(int i=0;i<num_battery;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int dist = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				battery_list[i] = new battery(x, y,dist,power);
			}
			
			int A_x=0, A_y=0;
			int B_x=9, B_y=9;
			get_sum(A_x, A_y, B_x, B_y);
			for(int i=0;i<num_move;i++) {
				//사용자A,B의 위치를 한칸 옮긴다.
				A_x += dx[move[0][i]];
				A_y += dy[move[0][i]];
				B_x += dx[move[1][i]];
				B_y += dy[move[1][i]];
				
				//충전량 더한다.
				get_sum(A_x, A_y, B_x, B_y);

			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
	public static void get_sum(int A_x, int A_y, int B_x, int B_y) {
		ArrayList<battery> arr_A = new ArrayList<battery>();
		ArrayList<battery> arr_B = new ArrayList<battery>();
		for(int i=0; i<num_battery;i++) {
			battery temp = battery_list[i];
			if(Math.abs(A_x - temp.x) + Math.abs(A_y - temp.y) <= temp.dist) {
				arr_A.add(temp);
			}
			if(Math.abs(B_x - temp.x) + Math.abs(B_y - temp.y) <= temp.dist) {
				arr_B.add(temp);
			}
		}
		int max = -1;
		if(arr_A.size() == 0 && arr_B.size() == 0)	return;
		else if(arr_A.size() == 0 && arr_B.size() != 0){
			for(int k=0;k<arr_B.size();k++) {
				max = Math.max(max, arr_B.get(k).power);
			}
		}
		else if(arr_A.size() != 0 && arr_B.size() == 0){
			for(int k=0;k<arr_A.size();k++) {
				max = Math.max(max, arr_A.get(k).power);
			}
		}
		else {
			for(int i=0;i<arr_A.size();i++) {
				int temp;
				for(int k=0;k<arr_B.size();k++) {
					temp = arr_A.get(i).power + arr_B.get(k).power;
					if(arr_A.get(i).equals(arr_B.get(k))) {
						temp = temp/2;
					}
					max = Math.max(max, temp);
				}
			}
		}
		answer += max;
		return;
	}
}

class battery{
	int x;
	int y;
	int dist;
	int power;
	public battery(int x, int y, int dist, int power) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.power = power;
	}
//	@Override
//	public String toString() {
//		return "battery [x=" + x + ", y=" + y + ", dist=" + dist + ", power=" + power + "]";
//	}
}
