import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Integer[][][] memoization = new Integer[21][21][21];
        
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1)
				break;

			sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c, memoization)).append("\n");
		}

		System.out.println(sb);
	}

	private static int w(int a, int b, int c, Integer[][][] memoization) {
		if (inRange(a, b, c) && memoization[a][b][c] != null) {
			return memoization[a][b][c];
		}

		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}

		if (a > 20 || b > 20 || c > 20) {
			return memoization[20][20][20] = w(20, 20, 20, memoization);
		}

		if (a < b && b < c) {
			return memoization[a][b][c] = w(a, b, c - 1, memoization) + w(a, b - 1, c - 1, memoization) - w(a, b - 1, c, memoization);
		}

		return memoization[a][b][c] = w(a - 1, b, c, memoization) + w(a - 1, b - 1, c, memoization) + w(a - 1, b, c - 1, memoization)
				- w(a - 1, b - 1, c - 1, memoization);
	}

	static boolean inRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
	}

}
