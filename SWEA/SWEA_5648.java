package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5648 {
	static ArrayList<Atom>[][] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder("");
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList[1000][1000];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(br.readLine());
				int y = Integer.parseInt(br.readLine());
				int dir = Integer.parseInt(br.readLine());
				int energy = Integer.parseInt(br.readLine());
				list[x][y].add(new Atom(dir,energy));
			}
		}

	}
	
	public static class Atom{
		int dir;
		int energy;
		public Atom(int dir, int energy) {
			this.dir = dir;
			this.energy = energy;
		}

		
		
	}

}
