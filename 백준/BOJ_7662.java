package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case;
		test_case = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<test_case;tc++) {
			int N = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				int number = Integer.parseInt(st.nextToken());
				if(c == 'I') {
					if(!map.containsKey(number)) {
						map.put(number, 1);
					}
					else {
						int count = map.get(number);
						map.put(number, count+1);
					}
				}
				else {//D일때
					if(map.isEmpty()) {
						continue;
					}
					else {
						if(number == 1) {
							number = map.lastKey();
						}
						else {
							number = map.firstKey();
						}
						
						int count = map.get(number);
						if(count == 1) {
							map.remove(number);
						}
						else {
							map.put(number, count-1);
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder("");
			if(map.isEmpty()) {
				sb.append("EMPTY");
			}
			else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey());
			}
			System.out.println(sb);
			
		}
		
		
		

	}

}
