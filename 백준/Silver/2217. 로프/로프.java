import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfRope = sc.nextInt();
		int[] rope = new int[numberOfRope];
		int maxAnswer = 0;

		for (int i = 0; i < numberOfRope; i++) {
			rope[i] = sc.nextInt();
		}

		Arrays.sort(rope);

		for (int i = 0; i < numberOfRope; i++) {
			maxAnswer = Math.max(maxAnswer, rope[i] * (numberOfRope - i));
		}

		System.out.println(maxAnswer);
	}

}