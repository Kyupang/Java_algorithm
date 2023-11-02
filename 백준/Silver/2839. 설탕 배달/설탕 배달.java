import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nKilogram = scanner.nextInt();

		int answer = 0;
		while (nKilogram >= 0) {
			if (nKilogram % 5 == 0) {
				answer += nKilogram / 5;
				break;
			}
			nKilogram -= 3;
			answer++;
		}

		if (nKilogram < 0) {
			answer = -1;
		}

		System.out.println(answer);
	}

}
