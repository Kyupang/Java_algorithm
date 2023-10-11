import java.util.*;
class Solution {

	ArrayList<Integer> a[];
	boolean[] visited;
	int[] dist;
	
	public int solution(int n, int[][] edge) {
		a = new ArrayList[n+1];
		visited = new boolean[n+1];
		dist = new int[n+1];
		int answer = 0;
		
		for(int i=1 ; i<=n ; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0 ; i< edge.length ; i++) {
			int start = edge[i][0];
			int end = edge[i][1];
			
			a[start].add(end);
			a[end].add(start);
		}
		
		bfs(1);
		
		int maxDist = Arrays.stream(dist).max().getAsInt();
		answer = (int) Arrays.stream(dist).filter(d -> d == maxDist).count();

		return answer;
	}

	private void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[node] = true;
		queue.add(node);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : a[now]) {
				if(!visited[next]) {
					dist[next] = dist[now]+1;
					visited[next] = true;
					queue.add(next);
				}
			}
		}
    }
}