import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;

public class Main {
//현재 상태에서 보는 선택지중 최선의 선택지가 전체에서 최선이라고 가정.
	public static void main(String[] args) throws IOException {
		// 1. 해선택 : 최선인 것 같은것 
		// 2. 적절성 검사 : 현재선택한 해가 전체 문제의 제약조건에 벗어나는지?
		// 3. 해검사 : 현재까지의 해 집합이 해결가능?
		// 1,2,3 반복
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		for(int i = 0 ; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int resultCount = 0;
		// 이게 그리디 알고리즘이야 
		// 이렇게 구하는 조건은 정보가 배수로 나왔을 때 쌉가능 
		// 배수로 안나오면 다른 알고리즘 생각해봐야할걸?
		for(int i = N-1; i>=0 ; i--) {
			if(A[i] <= k) {
				resultCount += k/A[i];
				k = k% A[i];
			}
		}
		
		System.out.println(resultCount);
		
	}

}