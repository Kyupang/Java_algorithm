import java.util.Scanner;

public class Main {
	private static final int FIVE_KILOGRAM_SUGAR = 5;
	private static final int THREE_KILOGRAM_SUGAR = 3;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalSugarQuantity = scanner.nextInt();
		int bag = 0;
		
		while (totalSugarQuantity >= 0) {
			if (totalSugarQuantity % FIVE_KILOGRAM_SUGAR == 0) {
				bag += totalSugarQuantity / FIVE_KILOGRAM_SUGAR;
				break;
			}
			totalSugarQuantity -= THREE_KILOGRAM_SUGAR;
			bag++; // 3kg 카운트 증가
		}

		if (totalSugarQuantity < 0) {
			bag = -1;
		}

		System.out.println(bag);
	}

}
