import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int numOfCity = Integer.parseInt(br.readLine());

		long[] dist = new long[numOfCity - 1];
		long[] oilCost = new long[numOfCity];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numOfCity - 1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numOfCity; i++) {
			oilCost[i] = Long.parseLong(st.nextToken());
		}

		long currentCost = oilCost[0];
		long totalCost = 0;
		for (int i = 0; i < numOfCity - 1; i++) {
			if (currentCost > oilCost[i]) {
				currentCost = oilCost[i];
			}

			totalCost += currentCost * dist[i];
		}
		
		System.out.println(totalCost);
	}

}
