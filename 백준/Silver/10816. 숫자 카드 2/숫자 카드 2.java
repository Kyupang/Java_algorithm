import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int numOfCards = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> cards = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numOfCards; i ++) {
			Integer card = Integer.parseInt(st.nextToken());
			
			cards.put(card, cards.getOrDefault(card, 0) + 1);
		}
		
		int numOfTarget = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numOfTarget; i++) {
			int target = Integer.parseInt(st.nextToken());

			sb.append(cards.getOrDefault(target, 0)).append(" ");
		}
        System.out.println(sb);
	}

}
