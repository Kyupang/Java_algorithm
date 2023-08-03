import java.util.Scanner;

public class Main {
	
	static int[] D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		D = new int[1001];
		D[0] = 0;
		D[1] = 1;
		D[2] = 2;
		for(int i=3; i< N+1 ; i++) {
			D[i] = (D[i-1]+D[i-2]) % 10007;
		}
		
		
		System.out.println(D[N]);
	}


}