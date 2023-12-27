import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int lengthOfLine = Integer.parseInt(br.readLine());
		int[] maxContiLength = new int[lengthOfLine + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= lengthOfLine; i++) {
			int target = Integer.parseInt(st.nextToken());
			maxContiLength[target] = maxContiLength[target - 1] + 1; 
		}
		
		System.out.println(lengthOfLine - Arrays.stream(maxContiLength).max().getAsInt());
	}
}