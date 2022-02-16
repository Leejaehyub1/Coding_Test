package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4012 {

	public static int N;
	public static int[] foodcase, score, selected;
	public static int[][] material;
	public static ArrayList<int []> food1lst;

	public static void main(String[] args) throws IOException{	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    int T = Integer.parseInt(br.readLine());
	    for(int testcase = 1; testcase <= T; testcase++) {
	        
	        N = Integer.parseInt(br.readLine());
	        material = new int[N][N];
	        for(int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine(), " ");
	            for(int j = 0; j < N; j++) {
	                material[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }
	        foodcase = new int[N/2];
	        food1lst = new ArrayList<int[]> ();
	        
	        //절반 뽑아서 food1lst에 저장.
	        combination(0, 0);

	        
	        //2개씩 뽑기
	        score = new int[food1lst.size()];
	        for(int i = 0 ; i < food1lst.size(); i++) {
	            selected = new int[2];
	            combination2(0, 0, i);
	        }
	    
	        //score 다 선택됬다.
	        int Min = Integer.MAX_VALUE;
	        for(int i =0; i< food1lst.size()/2; i++) {
	            int sum = Math.abs(score[i] - score[food1lst.size()-i-1]);
	            if(sum < Min) Min = sum;
	        }
	        System.out.println("#"+testcase+" "+Min);

	    }
	}
	public static void combination2(int cnt, int start, int idx) {
	    if(cnt == 2) {
	        int synerz = material[selected[0]][selected[1]] + material[selected[1]][selected[0]];
	        score[idx] += synerz;
	        return ;
	    }
	    for(int i = start; i < N/2 ; i++) {
	        selected[cnt] = food1lst.get(idx)[i];
	        combination2(cnt+1, i+1, idx);
	    }
	}

	public static void combination(int cnt, int start) {
	    if(cnt == N/2) {
	        food1lst.add(foodcase.clone()); //clone은 1차원 배열까지만 deep-copy
	        return ;
	    }
	    for(int i = start; i < N; i++) {
	        foodcase[cnt] = i;
	        combination(cnt+1, i+1);
	    }
	}
}
