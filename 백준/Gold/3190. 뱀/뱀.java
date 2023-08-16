import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
				// 우 하 좌 상 1 인덱스가 시계방향 90도 회전 
	static int[] dx = {0 ,1 ,0 ,-1};
	static int[] dy = {1 ,0 ,-1 ,0};
	static List<int[]> snake = new ArrayList<>();
	static Map<Integer, String> hash = new HashMap<>();
	static int N, K ,L ;
	static int[][] A;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N+1][N+1];
		
		for(int i= 0; i< K ; i++) {
			st = new StringTokenizer(br.readLine());
			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());
			
			A[ax][ay] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		for(int i= 0; i< L ;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String rotate = st.nextToken();
			hash.put(x, rotate);
		}
		
		play();
		
	}


	private static void play() {
		// 초기화 
		// 현재 위치
		int cx = 1;
		int cy = 1;
		
		// 시간 
		int time = 0;
		
		// 방향 초기화
		int d = 0;
		// now 현재위치 
		snake.add(new int[] {1, 1});
		
		while(true) {
			// 1. 시간재기
			time++;
			// 2. 뱀 이동하기 
			int nx = cx + dx[d];
			int ny = cy + dy[d];
			
			// 3. 범위를 벗어나거나, 뱀 몸통 만날 때 종료
			if(isFinish(nx,ny)) break;
			
			// 4. 사과가 있을 때 없을 때 처리 
			// 만약 이동중에 nx ny의 위치에 1이 있으면 snake에 그 좌표 추가 
			// 디스플레이에 보여줄 필요는 없다. 
			// 좌표만 추가하고 꼬리는 어짜피 따라오는거니까 
			if(A[nx][ny] == 1) {
				A[nx][ny] = 0;
				snake.add(new int[] {nx,ny});
			}else{
				snake.add(new int[] {nx,ny});
				snake.remove(0);
			}
			
			
			// 5. 방향을 바꿔주는 시간을 만날 때 방향 변경 
			if(hash.containsKey(time)) {
				if(hash.get(time).equals("D")) {
					d+=1;
					if(d == 4) {
						d= 0;
					}
				}else {
					d-=1;
					if(d== -1) {
						d= 3;
					}
				}
			}
			
			
			// 6. 현재값 업데이트 
			cx = nx;
			cy = ny;
		}
		
		System.out.println(time);
		
	}


	private static boolean isFinish(int nx, int ny) {
		if(nx < 1 || ny < 1 || nx > N || ny > N) {
			return true;
		}
		
		// snake 자체가 가지고 있는 좌표를 돌면서 
		// 그 좌표랑 nx ny가 같다면 true;
		for (int i = 0; i < snake.size(); i++) {
			int[] t = snake.get(i);
			if (nx == t[0] && ny == t[1])
				return true;
		}
		
		return false;
	}

}
