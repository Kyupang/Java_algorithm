
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
//첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.	
//	4 5 1
//	1 2
//	1 3
//	1 4
//	2 4
//	3 4
	
	static List<Integer> A[];
	static boolean visited[];
	static boolean visited2[];
	
	static StringBuffer str;
	static StringBuffer str2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int V = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		visited2 = new boolean[N+1];
		A = new ArrayList[N+1];
		for(int i =1 ; i< N+1 ; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		
		for(int i = 0; i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e);
			A[e].add(s);
		}
		
		// dfs 시작해보자.
		str = new StringBuffer();
		str2 = new StringBuffer();
		
		if(!visited[V]) {
			str.append(V+" ");
			str2.append(V+" ");
			DFS(V);
			BFS(V);
		}
		
		System.out.println(str.toString());
		System.out.println(str2.toString());
	}
	
	
	

	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		visited2[v] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			Collections.sort(A[now]);
			for(int x : A[now]) {
				if(!visited2[x]) {
					visited2[x] = true;
					str2.append(x+" ");
					queue.add(x);
				}
			}
		}
		
		
		
	}




	private static void DFS(int v) {
		if(visited[v]) return;
		
		visited[v] = true;
		
		Collections.sort(A[v]);
		for(int x : A[v]) {
			if(!visited[x]) {
				str.append(x+" ");
				DFS(x);
			}
		}
	}

}
