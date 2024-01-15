import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int boardRowSize = Integer.parseInt(st.nextToken());
		int boardColSize = Integer.parseInt(st.nextToken());

		board = new int[boardRowSize][boardColSize];
		boolean[][] visited = new boolean[boardRowSize][boardColSize];

		for (int i = 0; i < boardRowSize; i++) {
			String inputLine = br.readLine();
			for (int j = 0; j < boardColSize; j++) {
				board[i][j] = Integer.parseInt(inputLine.substring(j, j + 1));
			}
		}

		findEndOfMaze(0, 0, visited);
		System.out.println(board[boardRowSize - 1][boardColSize - 1]);
	}

	private static void findEndOfMaze(int row, int col, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { row, col });
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			int[] currentPosition = queue.poll();
			
			if (currentPosition[0] == board.length - 1 && currentPosition[1] == board[0].length - 1)
				return;
			
			for (int k = 0; k < 4; k++) {
				int nextRow = currentPosition[0] + dr[k];
				int nextCol = currentPosition[1] + dc[k];
				
				if (nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length)
					continue;
				if (board[nextRow][nextCol] == 0 || visited[nextRow][nextCol])
					continue;
				
				queue.offer(new int[] { nextRow, nextCol });
				board[nextRow][nextCol] = board[currentPosition[0]][currentPosition[1]] + 1;
				visited[nextRow][nextCol] = true;
			}
		}

	}

}