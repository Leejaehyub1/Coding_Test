package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice_01 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder("");
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int[] arr = new int[10];
			Rabbit[] rabbits = new Rabbit[5];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<10;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<5;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				rabbits[i] = new Rabbit(x, y, true);
			}
			
			for(int i=0;i<10;i++) {
				if(i != 0) {
					int diff = arr[i] - arr[i-1];
					if(0 < diff) {
						for(int k=0;k<5;k++) {
							if(rabbits[k].flag && rabbits[k].up < diff) {
								rabbits[k].flag = false;
							}
						}
					}
					else {
						for(int k=0;k<5;k++) {
							if(rabbits[k].flag && rabbits[k].down < diff*(-1)) {
								rabbits[k].flag = false;
							}
						}
						
					}
				}
			}
			int sum = 0;
			for(Rabbit r: rabbits) {
				if(r.flag)	sum++;
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);

	}
	static class Rabbit{
		int up;
		int down;
		boolean flag;
		public Rabbit(int x, int y, boolean f) {
			this.up = x;
			this.down = y;
			flag = f;
		}
	}

}
