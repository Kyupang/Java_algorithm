import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] dp = new int[n * m + 1];
		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i <= n * m; i++) {
			dp[i] = i - 1;

			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] * 2 + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] * 3 + 2);
			}
		}

		System.out.println(dp[n * m]);
	}

}