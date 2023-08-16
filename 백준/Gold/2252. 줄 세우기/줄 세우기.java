
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//위상정렬
	// 노드간의 순서를 결정함
	// 사이클이 없어야됨 
	// 항상 유일한 값으로 나오지 않음 
	
	// 진입차수가 0인 노드를 정렬 배열에 처음에 저장
	// 연결된 노드의 진입차수를 1씩 빼주삼
	// 그 다음 0인 노드 기존 정렬 배열에 넣으삼 
	
	// 백준 2252
	
	static ArrayList<Integer>[] A;
	static int[] jinip ;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		for(int i =1 ; i< N+1 ; i++) {
			A[i] = new ArrayList<Integer>();
		}

		queue = new LinkedList<Integer>();
		jinip = new int[N+1];
		
		for(int i= 0; i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			A[start].add(end);
			
			jinip[end] += 1;
		}
		
		for(int i= 1; i< jinip.length ; i ++) {
			if(jinip[i] == 0) {
				queue.offer(i);
			}
		}
		
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			
			for(int next : A[now]) {
				jinip[next]--;
				if(jinip[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		
	}

}