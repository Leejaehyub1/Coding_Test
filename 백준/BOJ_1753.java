package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int vertex;
	int weight;
	Node next;

	
	public Node(int vertex, int weight, Node next) {
		super();
		this.vertex = vertex;
		this.weight = weight;
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [vertex=" + vertex + "]";
	}
	
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

public class BOJ_1753 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());	//정점의 개수
		int E = Integer.parseInt(st.nextToken());	//간선의 개수
		int start = Integer.parseInt(br.readLine())-1;	//시작 정점의 번호
		final int INFINITY = Integer.MAX_VALUE;
		
		Node [] adjList = new Node[V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		
		int min=0, current=0;
		for(int i=0; i<V;++i) {
			min = INFINITY;
			for(int j=0; j<V;++j) {
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current]=true;
			if(adjList[current] == null) continue;
			for(Node temp = adjList[current]; temp!=null; temp=temp.next) {
				if(!visited[temp.vertex] && distance[temp.vertex] > min+temp.weight) {
					distance[temp.vertex] = min + temp.weight;
				}
			}
		}
		for(int i=0;i<distance.length;i++) {
			if(distance[i] == INFINITY) {
				System.out.println("INF");
			}
			else {
				System.out.println(distance[i]);
			}
		}
	}

}
