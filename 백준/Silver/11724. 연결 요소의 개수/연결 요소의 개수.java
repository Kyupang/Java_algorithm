import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// 핵심이론
	// 그래프 완전탐색 기법중 하나입니다.
	// 시작노드에서 출발하여 탐색할 한 쪽 분기를 정하여
	// 최대 깊이까지 탐색을 마친 후 다른 쪽 분기로 이동
	
	// 재귀함수로 구현 (스택오버플로우 고려)
	// 스택 자료구조 이용 
	
	// 시간복잡도 O(v+e) 
	
	// 한번 방문한 노드를 다시 방문하면 안됨
	// 1.그래서 노드 방문 여부를 체크할 배열 필요 !
	// 2.그래프는 인접 리스트로 표현 
	
	// 스택에 노드를 삽입할 때 
	// 방문배열을 체크하고
	// 스택에서 노드를 뺄때
	// 탐색순서에 기록하며
	// 인접노드를 방문 배열과 대조한다.
	
	
	// DFS가 끝날 때까지 탐색한 모든 노드의 집합을 하나의 연결요소라고 판단할 수 있음
	
	static boolean visited[];
	// 어레이 리스트 자료형의 배열을 만들어서 각각의 인덱스에 어레이 리스트를 만들어 줄것임.
	static List<Integer>[] A;
	
	public static void main(String[] args) throws IOException {
		//연결 요소의 개수 구하기 : 11724
		// 방향이 없는 그래프가 주어졌을 때 연결요소의 개수를 구하라
		//입력: 1번째 줄에 노드의 개수와 에지의 개수 주어짐
		//     M개의 줄에 에지의 양끝점 u,v가 주어진다. 같은 에지는 한 번만 주어진다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//노드의 개수
		int n = Integer.parseInt(st.nextToken());
		//엣지의 개수
		int m = Integer.parseInt(st.nextToken());
		
		// 방문 배열 // 0인덱스를 안쓸거라서.. 
		// 기본은 초기화ㅣ 해주지 않으면 false가 기본 
		visited = new boolean[n+1];
		
		// 인접리스트 (첫번째부터 마지막까지 어레이리스트 하나씩 만들어줘)
		A = new ArrayList[n+1];
		for(int i=1; i<n+1 ; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		// 밑에 m개의 명령어만큼 돌면서 스타트와 앤드를 다 A에 넣어줘 .
		// 양뱡향 연결이기 때문이다! 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			A[start].add(end);
			A[end].add(start);
		}
		
		// 연결요소 카운트
		int resultCount = 0;
		
		////////////////////////////////////////
		//DFS 시작 포인트
		// n개의 노드를 돌면서 
		for(int i = 1; i<n+1 ; i++) {
			// 방문하지 않은 노드라면
			// 왜냐면 방문하지 않았다는건 한 DFS에서 끝나고도 방문하지 않았다는 뜻이니까
			// 그래프가 별개라는 뜻 
			if(!visited[i]) {
				// 연결요소를 ++해주고 DFS 돌려야지.
				resultCount++;
				DFS(i);
			}
		}
		System.out.println(resultCount);
	}
	
	private static void DFS(int v) {
		// 현재 노드가 방문한 노드라면 return;
		// 방문하지 않은걸로 들어왔더라도 재귀함수가 불릴 때는 DFS가 처음 불리는 것
		// 따라서 return 값을 정해줘야함.
		if(visited[v]) return;
		// 현재 노드가 방문하지 않은 노드라면 방문처리를 해주고.
		visited[v] = true;
		
		// 인접노드에 들어가 있는 방문하지 않은 노드에 대해서 다시 DFS 를 실행.
		for(int i : A[v]) {
			if(!visited[i]) {
				DFS(i);
				
			}
		} 	
			
	}
	//DFS의 핵심 = 인접노드리스트
	//             방문배열
	//             재귀
	
}
