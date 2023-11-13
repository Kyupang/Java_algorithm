import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //인터넷 참고 코드
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int schedule = Integer.parseInt(br.readLine());
		int[] consultingTime = new int[schedule];
		int[] payment = new int[schedule];
		int[] maximumEarning = new int[schedule + 1];
		
		for (int i = 0; i < schedule; i++) {
			st = new StringTokenizer(br.readLine());
			consultingTime[i] = Integer.parseInt(st.nextToken());
			payment[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < schedule; i++) {
			if(i + consultingTime[i] <= schedule) { 
				maximumEarning[i + consultingTime[i]] = Math.max(maximumEarning[i + consultingTime[i]], maximumEarning[i] + payment[i]);
			}
			
			maximumEarning[i + 1] = Math.max(maximumEarning[i + 1], maximumEarning[i]); 
		} 
		
		System.out.println(maximumEarning[schedule]);
	}

}