import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, 1, 0, -1 }; // 하 우 상 좌
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static int[][] A;
	static int M, N;
	static int day;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		visited = new boolean[N][M];

		boolean hasZero = false;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				if (A[i][j] == 0) {
					hasZero = true; // 0이 있다면 플래그를 true로 설정
				}
			}
		}

		if (!hasZero) {
			System.out.println(0);
			return;// 0이 없으면 0 출력
		} else {
			day = 0;
			
			BFS();
			
			
			boolean hasRemainingZero = false;
			
			for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (A[i][j] == 0) {
                        hasRemainingZero = true;
                        break; // 0이 남아있다면 반복문 중단
                    }
                }
                if (hasRemainingZero) {
                    break;
                }
            }
            
            if (hasRemainingZero) {
                System.out.println(-1);
                return ;// 0이 남아있으면 -1 출력
            } else {
                System.out.println(day - 1); // 모두 익었으면 day 출력
                return ;
            }

		}
	}

	private static void BFS() {
	    Queue<int[]> queue = new LinkedList<>();
	    
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            if (A[i][j] == 1) {
	                queue.add(new int[] {i, j});
	                visited[i][j] = true;
	            }
	        }
	    }
	    
	    while (!queue.isEmpty()) {
	        int size = queue.size(); // 현재 턴에서 큐에 있는 요소들만 처리하기 위한 크기 저장
	        
	        for (int t = 0; t < size; t++) {
	            int[] now = queue.poll();
	            
	            for (int k = 0; k < 4; k++) {
	                int x = now[0] + dx[k];
	                int y = now[1] + dy[k];
	                
	                if (x >= 0 && y >= 0 && x < N && y < M) {
	                    if (A[x][y] == 0 && !visited[x][y]) {
	                        visited[x][y] = true;
	                        A[x][y] = 1;
	                        queue.add(new int[] {x, y});
	                    }
	                }
	            }
	        }
	        
	        day++; // 현재 턴이 끝나면 day 증가
	    }
	}

}