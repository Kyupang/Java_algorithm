
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int D[][] = new int[M+1][M+1];
			
			for(int j=0; j<M+1; j++) {
				D[j][j] = 1;
				D[j][0] = 1;
				D[j][1] = j;
			}
			
			//bottom up 
			for(int k=2; k< M+1 ; k++) {
				for(int m = 2; m<k ; m++) {
					D[k][m] = D[k-1][m] + D[k-1][m-1];
				}
			}
			
			System.out.println(D[M][N]);
		}

	}
 
}
