import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] representation;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numOfSet = Integer.parseInt(st.nextToken());
		int numOfQuestion = Integer.parseInt(st.nextToken());

		representation = new int[numOfSet + 1];

		for (int i = 1; i <= numOfSet; i++) {
			representation[i] = i;
		}

		for (int i = 0; i < numOfQuestion; i++) {
			st = new StringTokenizer(br.readLine());

			int question = Integer.parseInt(st.nextToken());
			int setA = Integer.parseInt(st.nextToken());
			int setB = Integer.parseInt(st.nextToken());

			if (question == 0) {
				union(setA, setB);
			} else {
				if (checkSame(setA, setB)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b)
			representation[b] = a;
	}

	private static int find(int x) {
		if (x == representation[x]) {
			return x;
		} else {
			return representation[x] = find(representation[x]);
		}
	}

	private static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return true;
		return false;
	}
}
