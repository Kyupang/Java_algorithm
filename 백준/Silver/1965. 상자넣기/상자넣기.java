import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int length = Integer.parseInt(br.readLine());

		int[] arr = new int[length];
		int[] LIS = new int[length];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < length; i++) {
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
				}
			}
		}
		System.out.println(Arrays.stream(LIS).max().getAsInt());
	}

}
