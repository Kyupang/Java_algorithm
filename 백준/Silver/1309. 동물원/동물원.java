import java.io.*;
import java.util.*;

public class Main {
	static Integer[][] dp;
    static final int MOD = 9901;
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		  dp = new Integer[100001][3];
	      int n = Integer.parseInt(br.readLine());
	      
	      dp[1][0] = 1;
	      dp[1][1] = 1;
	      dp[1][2] = 1;
	      
	      
	      for(int i=0; i<3; i++) {
	    	  recursive(n,i);
	      }
	      
	      System.out.println(((dp[n][0] + dp[n][1])%MOD + dp[n][2])%MOD);
	}
	private static Integer recursive(int n, int i) {
		if(dp[n][i] == null) {
			 if(i == 0){
		            dp[n][i] = ((recursive(n-1, 0) + recursive(n-1, 1))%MOD + recursive(n-1, 2))%MOD;
		        } else if(i==1){
		            dp[n][i] = (recursive(n-1, 0) + recursive(n-1, 2))%MOD;
		        } else {
		            dp[n][i] = (recursive(n-1, 0) + recursive(n-1, 1))%MOD;
		        }
		}
		
		return dp[n][i];
	}

}