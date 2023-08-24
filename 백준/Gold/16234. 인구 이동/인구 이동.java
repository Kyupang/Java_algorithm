
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,L,R;
	static int[][] map;
	static boolean visited[][];
	static ArrayList<int[]> yeonHap;
	static int day;		//우 하 좌 상 
	static int[] dx = {0, 1 ,0 ,-1};
	static int[] dy= {1, 0, -1 , 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		day = 0;
		
		
		for(int i=0; i <N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N ; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 데이터 다 받았으면 하루씩을 움직여야하니까 move 돌려 
		System.out.println(move());
	}

	private static int move() {
		// 처음 day는 0 이고 
		day = 0;
		
		// while 안에 있을때만 day는 유효하니까 그냥 return이 나올 때 까지 while 돌려 
		while(true) {
			
			// 인구이동 가능하니? 
			boolean isMove = false;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                	//방문하지 않았으면 
                	if(!visited[i][j]) {
                		// 그 좌표로 bfs 돌려버려 
                		// bfs에서는 sum을 꺼내올거임 
                        int sum = bfs(i, j); //bfs탐색으로 열릴 수 있는 국경선 확인 하며 인구 이동할 총 인구수 반환
                        // 두개가 안되면 못움직인거염
                        if(yeonHap.size() > 1) {
                        	changePopulation(sum);//열린 국경선 내의 노드들 인구 변경
                            isMove = true;
                        }    
                    }
                }
            }
			
			if(!isMove) return day ;
			day++;
		}
		
	}

	private static void changePopulation(int sum) {
		int avg = sum/ yeonHap.size();
		for(int[] position : yeonHap) {
			map[position[0]][position[1]] = avg;
		}
	}

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		yeonHap = new ArrayList<int[]>();
		
		visited[x][y] = true;
		yeonHap.add(new int [] {x,y});
		
		
		int sum= map[x][y];
		 while(!queue.isEmpty()) {
			 int[] now = queue.poll();
			 
			 for(int k =0; k< 4 ; k++) {
				 int nx = now[0] + dx[k];
				 int ny = now[1] + dy[k];
				 
				 if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
					 int diff = Math.abs(map[now[0]][now[1]] - map[nx][ny]);
					 if(L <= diff && diff <= R) {
						 queue.offer(new int[] {nx,ny});
						 yeonHap.add(new int[] {nx,ny});
						 
						 sum+= map[nx][ny];
						 visited[nx][ny] = true;
					 }
					 
				 }	 
			 }
		 }
		
		
		
		return sum;
	}


}