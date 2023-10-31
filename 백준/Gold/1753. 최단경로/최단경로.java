import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {
	static class Node{
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static ArrayList<Node> A[];
	static boolean visited[];
	static int[] dist;
	static int V,E,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[V+1];
		visited = new boolean[V+1];
		dist = new int[V+1];
		
		for(int i=1; i<V+1 ;i++) {
			A[i] = new ArrayList<Node>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i< E; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			A[node].add(new Node(edge,weight));
		}
		
		ditra(K);
		
		for(int i=1; i< dist.length; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
		}
	}
	private static void ditra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2) -> (o1.w - o2.w));
		pq.add(new Node(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(!visited[now.v]) {
				visited[now.v] = true;
			}
			
			for(Node next : A[now.v]) {
				if(!visited[next.v] && dist[next.v] > dist[now.v]+ next.w) {
					dist[next.v] = dist[now.v] + next.w;
					pq.add(new Node(next.v,dist[next.v]));
				}
			}
			
		}
	}

}