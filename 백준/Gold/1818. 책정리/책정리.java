import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int lengthOfSeq = Integer.parseInt(br.readLine());

		ArrayList<Integer> subSeq = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < lengthOfSeq; i++) {
			insertSubSeq(subSeq, Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(lengthOfSeq - subSeq.size());
	}

	private static void insertSubSeq(ArrayList<Integer> subSeq, int target) {
		int insertIdx = Collections.binarySearch(subSeq, target);

		if (insertIdx >= 0)
			return;

		insertIdx = -(insertIdx + 1);

		if (insertIdx >= subSeq.size()) {
			subSeq.add(target);
		} else {
			subSeq.set(insertIdx, target);
		}
	}
}
