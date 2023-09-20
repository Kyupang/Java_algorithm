
import java.util.*;
import java.io.*;

public class Main {
	static int[][] A;
	static int N;
	static boolean visited[];
	static int diff = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        visited = new boolean[N];
        for(int i =0; i< N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<N ; j++) {
        		A[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        dfs(0,0);
        
        System.out.println(diff);
	}
	private static void dfs(int idx, int selected) {
		if(selected == N/2) {
			calculate();
			return;
		}
		
		
		for(int i=idx ; i< N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1,selected+1);
				visited[i] = false;
			}
		}
	}
	private static void calculate() {
		int team_start = 0;
		int team_link = 0;
 
		for(int i = 0; i< N -1 ; i++) {
			for(int j = i+1; j< N ; j++) {
				if(visited[i] == true && visited[j] == true) {
					team_start += A[i][j];
					team_start += A[j][i];
				}else if (visited[i] == false && visited[j] == false) {
					team_link += A[i][j];
					team_link += A[j][i];
				}
			}
		}
		
		int val = Math.abs(team_start - team_link);
		
		if(val == 0) {
			System.out.println(val);
			System.exit(0);	
		}
		
		diff = Math.min(val, diff);
	}

}
 