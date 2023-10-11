import java.util.*;
public class Solution {
    
    static Integer[][] dp;
	static int N;
    
    public int solution(int[][] triangle) {
        N = triangle.length;
        dp = new Integer[N][N];
        
        for (int i = 0; i < N; i++) {
			dp[N - 1][i] = triangle[N - 1][i];
		}
        
        return find(0,0,triangle);
    }
    
    static int find(int depth, int idx, int[][] triangle) {
		// 마지막 행일 경우 현재 위치의 dp값 반환
		if(depth == N - 1) return dp[depth][idx];
 
		// 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
		if (dp[depth][idx] == null) {
			dp[depth][idx] = Math.max(find(depth + 1, idx,triangle), 
                                      find(depth + 1, idx + 1,triangle)) 
                                      + triangle[depth][idx];
		}
		return dp[depth][idx];
 
	}
}
