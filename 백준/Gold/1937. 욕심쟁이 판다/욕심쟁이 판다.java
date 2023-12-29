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

		int boardSize = Integer.parseInt(br.readLine());
		board = new int[boardSize][boardSize];
		int[][] memoi = new int[boardSize][boardSize];

		for (int i = 0; i < boardSize; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < boardSize; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int maxFood = 0;
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				maxFood = Math.max(maxFood, dfs(i, j, memoi));
			}
		}
		
		System.out.println(maxFood + 1);
	}

	private static int dfs(int row, int col, int[][] memoi) {
		if (memoi[row][col] != 0)
			return memoi[row][col];

		int maxFoodForDir = 0;
		for (int k = 0; k < 4; k++) {
			int nr = row + dr[k];
			int nc = col + dc[k];

			if (nr < 0 || nc < 0 || nr >= memoi.length || nc >= memoi.length)
				continue;

			if (board[nr][nc] > board[row][col]) {
				int foodForDir = 1 + dfs(nr, nc, memoi);
				maxFoodForDir = Math.max(maxFoodForDir, foodForDir);
			}
		}
		
		memoi[row][col] = maxFoodForDir;
		
		return maxFoodForDir;
	}

}
