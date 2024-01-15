import java.util.Scanner;

public class Main {
	static int[] representation;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int boardSize = sc.nextInt();
		int numOfvisitPlan = sc.nextInt();

		representation = new int[boardSize + 1];

		for (int i = 1; i <= boardSize; i++) {
			representation[i] = i;
		}

		for (int i = 1; i <= boardSize; i++) {
			for (int j = 1; j <= boardSize; j++) {
				if (sc.nextInt() == 1) {
					union(i, j);
				}
			}
		}
		
		int[] travelPlan = new int[numOfvisitPlan];
		for (int i = 0; i < numOfvisitPlan; i++) {
			travelPlan[i] = sc.nextInt();
		}
		
		System.out.println(checkPossibleToTravel(travelPlan) ? "YES" : "NO");
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

	private static boolean checkPossibleToTravel(int[] travelPlan) {
		int firstRoute = find(travelPlan[0]);
		
		for (int nextRoute : travelPlan) {
			if (firstRoute != find(nextRoute))
				return false;
		}
		return true;
	}

}
