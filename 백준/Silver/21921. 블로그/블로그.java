import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i< N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int max = 0; 
		int count = 0;
		
		for(int i = 0; i<X ; i++) {
			sum+= arr[i];
		}
		max = sum;
		count++;
		
		for(int i= X ; i<N ; i++) {
			int j = i-X;
			sum+= arr[i];
			sum-= arr[j];
			if(max < sum) {
				max = sum;
				count = 1;
			}else if(max == sum) {
				count++;
			}
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(max);
			System.out.println(count);
		}
		
		
		
	}
}