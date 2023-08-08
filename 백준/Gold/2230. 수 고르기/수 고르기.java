import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N =  Integer.parseInt(st.nextToken());
		int M =  Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		for(int i=0; i< N ; i ++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int diff;
		int min = Integer.MAX_VALUE;
		Arrays.sort(A);
		// 1 5 3
		// 1 3 5 
		// M =3 이라면
		// 배열을 돌면서 처음과 끝을 정해놓고 빼서 diff에 저장한다. 
		// diff가 M보다 클때만 진행
		// diff가 M보다 작을 때 end++ 
		// diff가 M하고 같을 때 
		// 그 diff가 min보다 작으면 min = diff ;
		// 그 diff가 min보다 크면 continue;  
		// 
		
		//차가 min보다 큰경우 start++;
		
		while (end < N && start < N) {
		    diff = A[end] - A[start];
		    
		    if (diff >= M) {
		        min = Math.min(min, diff);
		        start++;
		    } else {
		        end++;
		    }
		}

		if (min == Integer.MAX_VALUE) {
		    System.out.println(-1); // No valid difference found
		} else {
		    System.out.println(min);
		}
	}

}