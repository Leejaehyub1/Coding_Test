package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {

    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K;
        int W,H;
        boolean[][][] available;
        int[][] area;
        int ans = -1;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int[] hx = {-1,-2,-2,-1,1,2,2,1};
        int[] hy = {-2,-1,1,2,2,1,-1,-2};
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        area = new int[H][W];
        available = new boolean[H][W][K+1];
        for(int i =0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<W;j++){
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(W==1 && H==1) {
        	System.out.println("0");
        }
        else {
        	Queue<Monkey> queue = new LinkedList<Monkey>();
            queue.add(new Monkey(0,0,K,0));
            available[0][0][0] = true;

            while (!queue.isEmpty()){
                Monkey temp = queue.poll();
                int tempK = temp.leftK;
                if(tempK>0) {
                    for (int i = 0; i < 8; i++) {
                        int nx = temp.x + hx[i];
                        int ny = temp.y + hy[i];
                        if(0<=nx && nx<W && 0<=ny && ny<H && area[ny][nx] == 0 &&  !available[ny][nx][K - tempK +1]) {
                        	if(nx == W-1 && ny == H-1) {
                                ans = temp.move+1;
                                break;
                            }
                            queue.add(new Monkey(nx,ny,tempK-1,temp.move+1));
                            available[ny][nx][K-tempK+1] = true;
                        }
                    }
                }
                if(ans != -1) break;
                
                for(int i =0;i<4;i++){
                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];
                    if(0<=nx && nx<W && 0<=ny && ny<H && area[ny][nx]==0 &&  !available[ny][nx][K - tempK]) {
                    	if(nx == W-1 && ny == H-1) {
                            ans = temp.move+1;
                            break;
                        }
                        queue.add(new Monkey(nx,ny,tempK,temp.move+1));
                        available[ny][nx][K-tempK] = true;
                    }
                    
                }
                if(ans != -1) break;
            }
            System.out.println(ans);
        }
        
    }
}

class Monkey {
    int x;
    int y;
    int leftK;
    int move;


    public Monkey(int x, int y, int leftK, int move) {
        this.x = x;
        this.y = y;
        this.leftK = leftK;
        this.move = move;
    }
}