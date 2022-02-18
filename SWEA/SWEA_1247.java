package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247 {
	static int[] arr_x;
	static int[] arr_y;
	static int[] index_arr;
	static boolean[] isSelected;
	static int company_x;
	static int company_y;
	static int house_x;
	static int house_y;
	static int N;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			N = Integer.parseInt(br.readLine());
			arr_x = new int[N];
			arr_y = new int[N];
			index_arr = new int[N];
			isSelected = new boolean[N];
			answer = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			company_x = Integer.parseInt(st.nextToken());
			company_y = Integer.parseInt(st.nextToken());
			house_x = Integer.parseInt(st.nextToken());
			house_y = Integer.parseInt(st.nextToken());

			for(int i=0;i<N;i++) {
				arr_x[i] = Integer.parseInt(st.nextToken());
				arr_y[i] = Integer.parseInt(st.nextToken());
			}
			permutation(0);
			System.out.println("#"+test_case+" "+answer);
		}
		
	}
	public static void permutation(int cnt) {
		if(cnt == N) {
			int temp = 0;
			temp += (Math.abs(company_x-arr_x[index_arr[0]]) + Math.abs(company_y-arr_y[index_arr[0]]));
			for(int i=1; i<N;i++) {
				temp += (Math.abs(arr_x[index_arr[i]]-arr_x[index_arr[i-1]]) + Math.abs(arr_y[index_arr[i]]-arr_y[index_arr[i-1]]));
			}
			temp += (Math.abs(house_x-arr_x[index_arr[N-1]]) + Math.abs(house_y-arr_y[index_arr[N-1]]));
			answer = Math.min(temp, answer);
			return;
		}
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i]=true;
			index_arr[cnt]=i;
			permutation(cnt+1);
			isSelected[i]=false;
		}	
	}

}
