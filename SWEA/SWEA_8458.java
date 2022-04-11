package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8458 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[N];
			long max = 0;
			boolean isSame = true;
			int cnt = 0;
			long sum = 0;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[i] = Math.abs(x) + Math.abs(y);
				max = Math.max(max,  arr[i]);
				if(i != 0) {
					if(arr[i]%2 != arr[i-1]%2) {
						isSame = false;
					}
				}
			}
			if(!isSame) {
				sb.append("#").append(tc).append(" ").append("-1").append("\n");
				continue;
			}
//			if(max == 0) {
//				sb.append("#").append(tc).append(" ").append("0\n");
//				continue;
//			}

			while(true) {
				
				if(max <= sum && (sum-max)%2 ==0) {
					sb.append("#").append(tc).append(" ").append(cnt).append("\n");
					break;
				}
				cnt ++;
				sum+= cnt;
				
			}
		}
		System.out.println(sb);
	}

}
