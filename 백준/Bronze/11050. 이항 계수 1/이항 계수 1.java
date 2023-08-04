import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,K;
		int D[][];
		
		N= sc.nextInt();
		K = sc.nextInt();
		D = new int[N+1][N+1];
		
		for(int i=0; i<N+1; i++) {
			D[i][i] = 1;
			D[i][0] = 1;
			D[i][1] = i;
		}
		
		//bottom up
		for(int i = 2; i< N+1 ; i++) {
			for(int j=2; j<i ; j++) {
				D[i][j] = D[i-1][j] + D[i-1][j-1];
			}
		}
		
		System.out.println(D[N][K]);
	}

}
