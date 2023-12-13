import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int lengthOfSeq = Integer.parseInt(br.readLine());
		int[] seq = new int[lengthOfSeq];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < lengthOfSeq; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] LIS = new int[lengthOfSeq];
		LIS[0] = seq[0];
		int lengthOfLIS = 1;
		
		for (int i = 1; i < lengthOfSeq; i++) {
			lengthOfLIS = findMaxLength(LIS,lengthOfLIS,seq[i]);
		}
		
		System.out.println(lengthOfLIS);
	}

	private static int findMaxLength(int[] LIS, int lengthOfLIS, int target) { 
		if (LIS[lengthOfLIS - 1] < target) {
			lengthOfLIS++;
			LIS[lengthOfLIS - 1] = target;
		} else {
			int left = 0;
			int right = lengthOfLIS;
			
			while(left < right) {
				int mid = (left + right) / 2;
				
				if(LIS[mid] >= target) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			LIS[left] = target;
		}
		return lengthOfLIS;
	}

}
