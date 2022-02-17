package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3109 {
    static int R;
    static int C;
    static char[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    map = new char[R][C];
	    
//	    history = new int[C-1];
	    for (int i = 0; i < R; i++) {
	        map[i] = br.readLine().toCharArray();
	    }
	
	    for(int i=0; i<R;i++) {
	    	if(function(i, 0)) {
	    		answer++;
	    	}
	    }
	    System.out.println(answer);
	}
    public static boolean function(int x, int y){
    	map[x][y] = 'x';
    	if(y==C-1) {
    		for(int i=0;i<R;i++) {
    			System.out.println(Arrays.toString(map[i]));
    		}
    		System.out.println();
			return true;
		}
		if(isAvailable(x-1,y+1)){
			if(function(x-1, y+1)) {
				return true;
			}
		}
		if(isAvailable(x,y+1)){
			if(function(x, y+1)) {
				return true;
			}
		}
		if(isAvailable(x+1,y+1)){
			if(function(x+1, y+1)){
				return true;
			}
		}
    	return false;
    }
    public static boolean isAvailable(int nr, int nc) {
    	return (0<= nr && nr < R && nc < C && map[nr][nc] == '.');
    }
}
//System.out.println(Arrays.toString(history));
//for(int i=0;i<R;i++) {
//	System.out.println(Arrays.toString(map[i]));
//}

//public static void calculate(int r, int c) {
//	if(c == (C-1)) {
//		for(int k=0; k<C;k++) {
//			map[history[k]][k] = 'x';
//		}
//		System.out.println(Arrays.toString(history)); 
//		answer ++;
//		return;
//	}
//	for(int i=0; i<3;i++) {
//		int nr = r+dx[i];
//		int nc = c+1;
//		if(isAvailable(nr,nc)) {
//			history[nc] = nr;
//			calculate(nr, nc);
//		}
//	}
//	return;
//	
//}
//static void dfs(int colNo) {
//// x 거나 배열 밖이면 안됨.
////if (isAvailable(colNo))
////    ;
//for (int i = 0; i < R; i++) {
//    r[colNo] = i;
//
//    dfs(colNo + 1);
//
//}
//}
//
//// 현재까지 가능한 colNo는 colNo-1
//static boolean isAvailable(int colNo) {
//int y = r[colNo];
//if (map[y - 1][colNo] != 'x')
//    return true;
//else if (map[y][colNo] != 'x')
//    return true;
//else if (map[y + 1][colNo] != 'x')
//    return true;
//
//return false;
//}
//
//static boolean foo(int colNo) {
//int x = r[colNo];
//int y = colNo;
//
//for (int i = 0; i < 3; i++){
//    int nx = x+dx[i];
//    int ny = y+1;
//    
//    if(map[nx][ny]!='x') {
//    	return true;            
//    }
//}
//return false;
//}
//f(x,y)
//	if(y==C-1) {
//		answer++ return;
//	}
//	else if(isAvailable(x-1,y+1)){
//		return f(x-1, y+1);
//	}
//	else if(isAvailable(x,y+1)){
//		return f(x, y+1);
//	}
//	else if(isAvailable(x+1,y+1)){
//		return f(x+1, y+1);
//	}
//}


