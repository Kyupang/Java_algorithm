import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
//내가 한 방법은 시간초과가 나서 2차원 배열 구간합에 대해서 학습하였다. 
	
	//합배열 sum[i][j] = array[i][j] + sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1];
	//구간 [i, j] ~ [x, y]의 합은 sum[x][y] - sum[i-1][y] - sum[x][j-1] + sum[i-1][j-1]
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());


//		for(int i =0; i< N ; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = 0; j<N ; j++) {
//				A[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		int[][] cover = new int[M][4];
//		for(int i =0; i< M ; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = 0; j<4 ; j++) {
//				cover[i][j] = Integer.parseInt(st.nextToken()) -1;
//			}
//		}
//		
//		
//		int[][] cuSum = new int[N][N];
//		
//		for(int i =0; i< N ; i++) {
//				cuSum[i][0] = A[i][0];
//		}
//		
//		for(int i =0; i< N ; i++) {
//			for(int j = 1; j<N ; j++) {
//				cuSum[i][j] = cuSum[i][j-1] + A[i][j];
//			}
//		}
//		
//		
//		int resultSum = 0;
//		//구간합 구하기 범위로 처음과 끝이 있다면  구간합=cuSum[end] - cuSum[start -1];  
//		// start는 cover[i][1]
//		// end =   cover[i][3] 
//		// for 문을 돌릴 때 행은 k = cover[i][0] 부터 k = cover[i][2] 까지 하면서 cuSum의 값 출력
//		// 얼만큼 출력? i = 0; i < M 까지 
//		
//		for(int i = 0; i<M ; i++) {
//			for(int k = cover[i][0] ; k<= cover[i][2]; k++) {
//				resultSum += cuSum[k][cover[i][3]] - (cover[i][1] > 0 ? cuSum[k][cover[i][1] - 1] : 0);
//			}
//			System.out.println(resultSum);
//			resultSum=0;
//		}

		// n x n 크기의 2차원 배열을 선언한다.
		int[][] array = new int[N + 1][N + 1];
		// 각 원소의 합을 저장할 2차원 배열을 선언한다.
		int[][] sum = new int[N + 1][N + 1];

		// n x n 크기의 배열에 값을 입력하고 각각의 원소의 합을 구한다.
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				array[i][j] =  Integer.parseInt(st.nextToken());// 입력값을 배열에 저장한다.
				// i, j 위치의 값이 포함된 부분합을 구한다.
				// 이전 부분합인 sum[i][j-1]과 sum[i-1][j]를 더하고,
				// 중복으로 더해진 sum[i-1][j-1]을 빼면 현재 부분합을 구할 수 있다.
				sum[i][j] = array[i][j] + sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1];
			}
		}

		// 주어진 범위 내의 합을 구한다.
		for (int i = 1; i <= M; i++) {
			st=  new StringTokenizer(br.readLine());
			int x1 =  Integer.parseInt(st.nextToken()); // 시작 위치의 x좌표
			int y1 =  Integer.parseInt(st.nextToken()); // 시작 위치의 y좌표
			int x2 =  Integer.parseInt(st.nextToken()); // 끝 위치의 x좌표
			int y2 =  Integer.parseInt(st.nextToken()); // 끝 위치의 y좌표
			// 부분합을 이용하여 주어진 범위 내의 합을 계산한다.
			// 구하려는 부분합은 sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 -
			// 1]이다.
			// 범위 내의 모든 원소의 합을 구한 후, 불필요한 부분을 빼주어 구하려는 부분합을 구한다.
			System.out.println(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]);
		}

	}

}
