import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int people = Integer.parseInt(br.readLine());
		int[] atmLine = new int[people];
        int[] prefixSum = new int[people];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < people; i++) {
			atmLine[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(atmLine);
		
        prefixSum[0] = atmLine[0];
        for (int i = 1; i < people; i++) {
            prefixSum[i] = prefixSum[i - 1] + atmLine[i];
        }

		System.out.println(Arrays.stream(prefixSum).sum());
	}

}
