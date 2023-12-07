import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numberOfSequences = Integer.parseInt(st.nextToken());
		int[] sequence = new int[numberOfSequences];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numberOfSequences; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		if (numberOfSequences == 1 || (numberOfSequences == 2 && sequence[0] != sequence[1])) {
			System.out.println("A");
			return;
		} else if (numberOfSequences == 2) {
			System.out.println(sequence[0]);
			return;
		}
		
		int a, b;
		if (sequence[1] == sequence[0]) {
			a = 1;
			b = 0;
		} else {
			a = (sequence[2] - sequence[1]) / (sequence[1] - sequence[0]);
			b = sequence[1] - (sequence[0] * a);
		}

		for (int i = 1; i < numberOfSequences; i++) {
			if (sequence[i] != (sequence[i - 1] * a + b)) {
				System.out.println("B");
				return;
			} 				
		}
        System.out.println(sequence[numberOfSequences - 1] * a + b);

	}

}
