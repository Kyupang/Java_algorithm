
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] A;
	static int[][] virusMap;
	static int N, M;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(max);
	}
	
	//벽세우기
	private static void dfs(int wall) {
		if(wall == 3) {
			bfs();
			return;
		}
		
		
		for(int i = 0; i< N; i++) {
			for(int j =0 ; j<M ; j++) {
				if(A[i][j] == 0) {
					A[i][j] = 1;
					dfs(wall+1);
					A[i][j] = 0;
				}
			}
		}
	}
	// 바이러스 퍼뜨리기
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
        virusMap = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = A[i][j];
                // 2인곳은 바이러스이니 확산해야하는 좌표이므로 
                // queue에 add해주삼 
                if (virusMap[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        // 그자리에서 꺼내면서 주위에 0이라면 2로 바꾸고 바꾼 곳 add하셈 while로 
        
        while(!q.isEmpty()) {
        	int[] now = q.poll();
        	
        	
        	for(int k =0; k< 4; k++) {
        		int x = now[0] + dx[k];
        		int y = now[1] + dy[k];
        		
        		if(x>= 0 && y>=0 && x<N &&y <M && virusMap[x][y] ==0) {
        			virusMap[x][y] = 2;
        			q.add(new int[] {x,y});
        		}
        	}
        }
        
        int count = 0;

		for(int i = 0; i< N; i++) {
			for(int j =0 ; j<M ; j++) {
				if(virusMap[i][j] == 0) {
					count++;
				}
			}
		}
        max = Math.max(count, max);
        
	}

}