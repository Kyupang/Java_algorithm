import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int numOfOrigin = Integer.parseInt(br.readLine());
		int[] origins = new int[numOfOrigin];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numOfOrigin; i ++) {
			origins[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(origins);
		
		int numOfTarget = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numOfTarget; i ++) {
			int left = 0;
			int right = numOfOrigin - 1;
			int target = Integer.parseInt(st.nextToken());
			boolean found = false;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				int midVal = origins[mid];
				
				if (midVal < target) {
					left = mid + 1;
				} else if (midVal > target) {
					right = mid - 1;
				} else {
					found = true;
					break;
				} 
			}
			
			System.out.println(found ? 1 : 0);
		}
	}

}
