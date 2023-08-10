import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] A = new int[N+1];
		
		for(int i =1 ; i< N+1; i++) {
			A[i] = i;
		}
		int count = 0;
		for(int i=2 ; i< N+1; i++) {
			if(A[i]==0)continue;
			for(int j=i ; j<N+1; j+=i) {
				if(A[j] !=0) {
					count++;
					A[j] = 0;
				}
				if(count == K) {
					System.out.println(j);
					return;
				}
				
			}
		}
	}

}