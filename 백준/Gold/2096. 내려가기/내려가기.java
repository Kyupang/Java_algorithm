import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int numberOfRow = Integer.parseInt(br.readLine());
		int[][] board = new int[numberOfRow][3];
		int[][] maxScore = new int[numberOfRow][3];
		int[][] minScore = new int[numberOfRow][3];

		for (int i = 0; i < numberOfRow; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			maxScore[0][i] = board[0][i];
			minScore[0][i] = board[0][i];
		}

		for (int i = 1; i < numberOfRow; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					maxScore[i][j] = Math.max(maxScore[i - 1][0], maxScore[i - 1][1]) + board[i][j];
					minScore[i][j] = Math.min(minScore[i - 1][0], minScore[i - 1][1]) + board[i][j];
				} else if (j == 1) {
					maxScore[i][j] = Math.max(Math.max(maxScore[i - 1][0], maxScore[i - 1][1]), maxScore[i - 1][2]) + board[i][j];
					minScore[i][j] = Math.min(Math.min(minScore[i - 1][0], minScore[i - 1][1]), minScore[i - 1][2]) + board[i][j];
				} else {
					maxScore[i][j] = Math.max(maxScore[i - 1][1], maxScore[i - 1][2]) + board[i][j];
					minScore[i][j] = Math.min(minScore[i - 1][1], minScore[i - 1][2]) + board[i][j];
				}
			}
		}

		System.out.println(Arrays.stream(maxScore[numberOfRow - 1]).max().getAsInt() +" "+ 
				Arrays.stream(minScore[numberOfRow - 1]).min().getAsInt());
	}

}