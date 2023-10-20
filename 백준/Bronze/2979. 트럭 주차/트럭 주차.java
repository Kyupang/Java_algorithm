
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] count = new int[101];
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			
			
			int inCar = Integer.parseInt(st.nextToken());
			int outCar = Integer.parseInt(st.nextToken());
			
			for(int j=inCar; j < outCar ; j++) {
				count[j] += 1;
			}
			
		}
		int feeSum = 0;
		for(int i=0; i <= 100 ; i++) {
			if(count[i] == 1) {
				feeSum +=A;
			}else if(count[i] ==2) {
				feeSum+=B*2;
			}else if(count[i] == 3) {
				feeSum+=C*3;
			}
		}
		
		System.out.println(feeSum);
	}

}
