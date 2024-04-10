import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static final int HOUSE = 1;
	static final int FOUR_DIRECTION = 4;
	
	static int[][] board;
	static int[] dr = {0, 1, 0 ,-1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int boardSize = Integer.parseInt(br.readLine());
		
		board = new int[boardSize][boardSize];
		boolean[][] visited = new boolean[boardSize][boardSize];
		
		for (int i = 0; i < boardSize; i++) {
			String inputLine = br.readLine();
			for (int j =0; j < boardSize; j++) {
				board[i][j] = Integer.parseInt(inputLine.substring(j, j + 1));
			}
		}
		
		List<Integer> buildingSizes = new ArrayList<>();
		
		for (int i = 0; i < boardSize; i++) {
			for (int j =0; j < boardSize; j++) {
				if (board[i][j] != HOUSE || visited[i][j]) 
					continue;
				
				buildingSizes.add(findNeighborhood(i,j,visited));
			}
		}
		
		System.out.println(buildingSizes.size());
		buildingSizes.stream().sorted().forEach(System.out::println);
	}

	private static Integer findNeighborhood(int row, int col, boolean[][] visited) {
		int buildingSize = 1;
		visited[row][col] = true;
		
		for (int k = 0; k < FOUR_DIRECTION; k++) {
			int nr = row + dr[k];
			int nc = col + dc[k];
			
			if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) 
				continue;
			
			if (board[nr][nc] != HOUSE || visited[nr][nc])
				continue;
			
			buildingSize += findNeighborhood(nr, nc, visited);
		}
		return buildingSize;
	}
}
