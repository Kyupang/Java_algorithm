import java.io.*;
import java.util.*;

public class Main {
//주몽의 명령
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i =0; i< arr.length ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int start = 0;
		int end = N-1;
		int count = 0;
		
		while(start < end) {
			if((arr[start]+arr[end])== M) {
				count++;
				start++;
				end--;
			}else if((arr[start]+arr[end]) < M){
				start++;
			}else {
				end--;
			}
		}
		
		System.out.println(count);
	}
}
