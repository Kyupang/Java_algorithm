
import java.util.*;
import java.io.*;


public class Main {
	
	public static int N;	// 정적변수로 변경
	public static int M;	// 정적변수로 변경
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		// 정적변수 N과 M을 초기화해준다.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
 
		arr = new int[M];
		visit = new boolean[N];
        
		// 정적변수를 쓰면 되기 때문에 굳이 N과 M을 넘겨줄 필요 없다.
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if(depth == M) {
			for(int value : arr) {
				sb.append(value+" ");
			}
			sb.append("\n");
			return;
		}
		
		
		
		for(int i= 0; i<N; i++ ) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
}
