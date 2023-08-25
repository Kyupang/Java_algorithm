
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 전체 집의 갯수
			int M = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우
			int K = Integer.parseInt(st.nextToken()); // 방범 작동 최소 돈
			
			int[] map = new int[N];
			int sum = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j =0; j< M ; j++) {
				sum+= map[j];
			}
			
			if(N == M) {
                if(sum < K) System.out.println("1");
                else System.out.println("0");
            } else {
                int count = 0;
 
                int start = 0;
                int end = M-1;
 
                while(start < N) {
                    if(sum < K) count++;
                    sum -= map[start++];
                    sum += map[(++end) % N];
                }
                System.out.println(count);
            }
			
			
		}

	}

}