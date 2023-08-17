
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;

public class Main {
	/*
	 * 일단 DFS를 이해해야함 못하고 있음 
	 * dfs에서의 행위는 움직였을 경우야. 이미 상정이 그렇게 되어있음 
	 * 못움직이면 끝내는건 dfs 를 돌렸는데 행위를 할게 없는 경우야 즉 그냥 끝내면 됨.
	 * 
	 * 이 문제에서 중요했던건 
	 * 케이스를 나누는 것이였는데
	 * 1. 그 자리에서 청소를 안했다면 -1 로바꾸고 count++
	 * 2. 방향을 -90도 돌려가면서 이동시킨 후에 그 자리에 청소를 안했다면 dfs를 돌림
	 * 3. 다 돌렸는데도 없었으면 후진 시키셈. 후진했는데 그 자리가 -1 이라면 dfs 
	 * 
	 * 이 1,2,3 번에 부합하지 못하면 그냥 끝내셈 
	 * 
	 */
	
	static int [][] map;
	static int n,m,r,c,d;
	static int count;
	// 이 방향이 -> 방향을 가리킨다. 북동남서 dx 는 행을 뜻하게 만들어 놨으니 이렇게 해야지...
	static int[] dx = { -1 , 0 , 1 , 0};
	static int[] dy = { 0 , 1 , 0 , -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0 ; i< n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		count = 0;
		dfs(r,c,d);
		
		System.out.println(count);
	}

	private static void dfs(int r, int c, int d) {
		// 1 1 0 이 들어온 상황 
		//1. 현재 자리에 청소 
		if (map[r][c] == 0) {
            map[r][c] = -1; // 청소 표시
            count++;
        }
		
		for(int i=0; i<4; i++) {
			// -90도 회전 
			d = (d +3)%4; // 왼쪽 방향으로 변환 (북 -> 서 -> 남 -> 동)
			int nx = r + dx[d];
			int ny = c + dy[d];
			
			// 청소가 안된 곳이 있으면 count++,  dfs
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                dfs(nx, ny, d);
                return; // 한 번 회전 후 바로 이동하도록 수정
            }
		}
		// 4방향을 다 돌았는데 0이 없었어.
		
		//청소가 안된곳이 없다면 
		int back = (d + 2) % 4;
		int bx = r + dx[back];
		int by = c + dy[back];
		
		// 0이 아니어서 넘어왔으니까 
		// d는 변함이 없고 
		 if (bx >= 0 && bx < n && by >= 0 && by < m && map[bx][by] != 1) {
	            dfs(bx, by, d);
	     }
		
		 
	}

	
}