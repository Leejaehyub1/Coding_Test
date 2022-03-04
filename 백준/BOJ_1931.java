package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meeting[] arr = new Meeting[N];
		StringTokenizer st = null;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Meeting(a,b);
		}
		Arrays.sort(arr);
		int count = 0;
		int time = 0;
//		System.out.println(Arrays.toString(arr));
		
		for(int i=0;i<N;i++) {
			if(time <= arr[i].start) {
				count++;
				time = arr[i].end;
//				System.out.println(arr[i].toString());
			}
		}
		System.out.println(count);

		
		
	}
	

}
class Meeting implements Comparable<Meeting>{
	int start;
	int end;
	public Meeting(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Meeting m) {
		if(this.end == m.end)	return this.start-m.start;
		return this.end-m.end;
	}
	
	@Override
	public String toString() {
		return "["+start+", "+end+"]";
	}
}
