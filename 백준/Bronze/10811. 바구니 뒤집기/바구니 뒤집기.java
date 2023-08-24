
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int I,J;
	static int[] A;
	static ArrayList<Integer> order;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new int[N+1]; 
		
		for(int i=1; i< N+1; i++) {
			A[i] = i;
		}
		
		
		for(int i=0; i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			
			// 배열의 인덱스를 I에서 J번까지 증가시키면서 
			// A[I] 와 A[J]를 swap 한다. 
			// I 는 증가 J는 감소
			for(int n = I ; n < J+1; n++) {
				int m = J--;
				
				int temp = A[n];
				A[n] = A[m];
				A[m] = temp;
			}
		}
		
		for(int i=1; i<N+1; i++) {
			System.out.print(A[i] + " ");
		}
	}
	

}
