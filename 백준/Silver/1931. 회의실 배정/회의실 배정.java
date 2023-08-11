
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		ArrayList<int []> A = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			A.add(new int[] {x,y});
		}
		
		 Collections.sort(A, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] o1, int[] o2) {
	                if (o1[1] == o2[1]) {
	                    return Integer.compare(o1[0], o2[0]);
	                }
	                return Integer.compare(o1[1], o2[1]);
	            }
	        });

	        int count = 0;
	        int endTime = 0; // 첫 번째 회의의 끝나는 시간 저장

	        for (int i = 0; i < A.size(); i++) {
	            if (A.get(i)[0] >= endTime) {
	                count++;
	                endTime = A.get(i)[1]; // 다음 회의의 끝나는 시간으로 갱신
	            }
	        }
		System.out.println(count);
	}

}
