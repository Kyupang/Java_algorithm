
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		int[][] answer = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'c') {
					answer[i][j] = 0;
				}else {
					int minDistance = Integer.MAX_VALUE;
					for(int k = j-1; k>= 0 ;k--) {
						if(map[i][k] == 'c') {
							minDistance = Math.min(minDistance, j-k);
						}
					}
					answer[i][j]= minDistance ==Integer.MAX_VALUE ? -1 : minDistance;
				}

				
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}

}
