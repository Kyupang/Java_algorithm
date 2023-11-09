import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] adjacencyList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numberOfNodes = Integer.parseInt(st.nextToken());
		int numberOfEdges = Integer.parseInt(st.nextToken());
		int ConnectedComponentCount = 0;

		adjacencyList = new List[numberOfNodes + 1];
		boolean[] visited = new boolean[numberOfNodes + 1];

		for (int i = 1; i <= numberOfNodes; i++) {
			adjacencyList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < numberOfEdges; i++) {
			st = new StringTokenizer(br.readLine());

			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());

			adjacencyList[startNode].add(endNode);
			adjacencyList[endNode].add(startNode);
		}

		for (int node = 1; node <= numberOfNodes; node++) {
			if (!visited[node]) {
				findConnectedComponent(node, visited);
				ConnectedComponentCount++;
			}
		}

		System.out.println(ConnectedComponentCount);
	}

	private static void findConnectedComponent(int currentNode, boolean[] visited) {
		if (visited[currentNode])
			return;

		visited[currentNode] = true;

		for (int nextNode : adjacencyList[currentNode]) {
			if (!visited[nextNode])
				findConnectedComponent(nextNode, visited);
		}
	}
}