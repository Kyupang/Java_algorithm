
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] switchs;
	static int n,m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		switchs = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i= 1; i<= n ; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(sex == 1) {
				boyMove(sex,num);
			}else if (sex == 2){
				girlMove(sex,num);
			}
		}
		
		for(int i=1; i<=n ; i++) {
			System.out.print(switchs[i]+" ");
			if(i%20 == 0) {
				System.out.println();
			}
		}
		
	}

	private static void girlMove(int sex, int num) {
		int i=num;
		int j=num;
		switchs[num] ^=1;
		while(i<=n && j>=1) {
			if(switchs[i] == switchs[j]) {
				switchs[i] ^=1;
				switchs[j] ^=1;
				i++;
				j--;
			}else {
				break;
			}
		}
		return;
	}

	private static void boyMove(int sex, int num) {
		for(int i=1; i<=n ;i++) {
			if(i % num ==0) {
				switchs[i] ^= 1; 
			}
		}
		
		return;
	}

}
