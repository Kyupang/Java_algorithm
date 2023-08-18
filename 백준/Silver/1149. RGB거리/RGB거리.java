
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static Integer [][] dp ;
	static int[][] houseColor;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N+1][4];
		houseColor = new int[N+1][4];
		min = Integer.MAX_VALUE;
		
		for(int i = 1 ; i< N+1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j< 4; j++ ) {
				houseColor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dp[1][1] = houseColor[1][1];
		dp[1][2] = houseColor[1][2];
		dp[1][3] = houseColor[1][3];
		
		if(N == 1) {
			System.out.println(Math.min(Math.min(dp[1][1], dp[1][2]), dp[1][3]));
		}
		
		System.out.println(Math.min(cost(N, 1), Math.min(cost(N,2), cost(N, 3))));
	}

	private static int cost(int n , int m) {
		if(dp[n][m] == null) {
		    if (m == 1) {
		        dp[n][m] = Math.min(cost(n - 1,3) , cost(n - 1,2)) + houseColor[n][m];
		    } else if (m == 2) {
		        dp[n][m] = Math.min(cost(n - 1,1) , cost(n - 1,3)) + houseColor[n][m];
		    } else if (m == 3) {
		        dp[n][m] = Math.min(cost(n - 1,2) , cost(n - 1,1)) + houseColor[n][m];
		    }
		}
		return dp[n][m];
	}

}