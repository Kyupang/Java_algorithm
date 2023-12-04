import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int numOfCity = Integer.parseInt(br.readLine());

		int[] dist = new int[numOfCity - 1];
		int[] oilCost = new int[numOfCity];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numOfCity - 1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numOfCity; i++) {
			oilCost[i] = Integer.parseInt(st.nextToken());
		}

		int currentCost = oilCost[0];
		int totalCost = 0;
		for (int i = 0; i < numOfCity - 1; i++) {
			totalCost += currentCost * dist[i];

			if (currentCost > oilCost[i + 1]) {
				currentCost = oilCost[i + 1];
			}
		}
		
		System.out.println(totalCost);
	}

}
