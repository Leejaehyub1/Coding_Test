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
		System.out.println(Arrays.toString(arr));
		
		for(int i=0;i<N;i++) {
			System.out.printf("%d %d\n", arr[i].start, time);
			if(arr[i].start >= time) {
				count++;
				time += arr[i].start+arr[i].len;
			}
		}
		System.out.println();
		System.out.println();
		System.out.println(count);
		
		
	}
	

}
class Meeting implements Comparable<Meeting>{
	int start;
	int len;
	public Meeting(int start, int len) {
		super();
		this.start = start;
		this.len = len;
	}
	
	@Override
	public int compareTo(Meeting m) {
		if(this.start == m.start)	return this.len-m.len;
		return this.start-m.start;
	}
	
	@Override
	public String toString() {
		return "["+start+", "+len+"]";
	}
}
