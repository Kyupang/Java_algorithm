import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()); 
		for(int i= 0; i< N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		
		int[] cuSum = new int[N];
		cuSum[0] = arr[0];
		for(int i=1 ; i<N; i++) {
			cuSum[i] = cuSum[i-1] + arr[i];
		}
		
	
		for(int i = 0; i< M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) -1; 
			int end = Integer.parseInt(st.nextToken()) -1 ;
			
			
			int sum = cuSum[end];
			
			if(start > 0) {
				sum-= cuSum[start-1];
			}
			
			System.out.println(sum);
			
		}
		
		br.close();
	}
}