import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

		int squareMatrixSize = Integer.parseInt(st.nextToken());
		int orderedPosition = Integer.parseInt(st.nextToken());

		int[][] prefixSum = new int[squareMatrixSize + 1][squareMatrixSize + 1];

		for (int i = 1; i <= squareMatrixSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= squareMatrixSize; j++) {
				prefixSum[i][j] = prefixSum[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < orderedPosition; i++) {
			st = new StringTokenizer(br.readLine());
            
			int startRow = Integer.parseInt(st.nextToken());
			int startColumn = Integer.parseInt(st.nextToken());
			int endRow = Integer.parseInt(st.nextToken());
			int endColumn = Integer.parseInt(st.nextToken());
            
            int answer = 0;
            for (int j = startRow; j <= endRow; j++) {
                answer += prefixSum[j][endColumn] - prefixSum[j][startColumn - 1];
            }
			sb.append(answer).append("\n");
		}
        System.out.print(sb);
	}

}
