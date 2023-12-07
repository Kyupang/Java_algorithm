import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int boardSize = Integer.parseInt(br.readLine());
		board = new int[boardSize][boardSize];

		for (int i = 0; i < boardSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < boardSize; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxSafeArea = 1;
		for (int k = 1; k < 101; k++) {
			boolean[][] visited = new boolean[boardSize][boardSize];
			int safeAreaCount = 0;
			
			for (int i = 0; i < boardSize; i++) {
				for (int j = 0; j < boardSize; j++) {
					if (!visited[i][j] && board[i][j] > k) {
						findSafeArea(i, j, k, visited, boardSize);
						safeAreaCount++;
					}
				}
			}
			maxSafeArea = Math.max(maxSafeArea, safeAreaCount);
		}

		System.out.println(maxSafeArea);
	}

	private static void findSafeArea(int currentRow, int currentCol, int height, boolean[][] visited, int boardSize) {
		visited[currentRow][currentCol] = true;

		for (int k = 0; k < 4; k++) {
			int nr = currentRow + dr[k];
			int nc = currentCol + dc[k];

			if (nr < 0 || nc < 0 || nr >= boardSize || nc >= boardSize)
				continue;

			if (!visited[nr][nc] && board[nr][nc] > height) {
				findSafeArea(nr, nc, height, visited, boardSize);
			}
		}
	}

}
