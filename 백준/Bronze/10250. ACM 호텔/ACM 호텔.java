import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i=0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int nthCustomer = Integer.parseInt(st.nextToken());
			
			int floor = nthCustomer % height;
			int roomNumber = nthCustomer / height + 1;
			
			if (floor == 0) {
				floor = height;
				roomNumber = nthCustomer / height;
			}
			
			System.out.println(floor * 100 + roomNumber);
		}
		
	}

}