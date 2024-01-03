
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] correct = new int[N];
        int low = 0, high = 0;

        for (int i = 0; i < N; i++) {
            correct[i] = sc.nextInt();
            high += correct[i];
        }
        high++; 

        while(low < high) {
        	int mid = (low + high) / 2;
        	int cnt = 0, sum = 0;
        	
        	for (int i = 0; i < N; i++) {
        		sum += correct[i];
        		
        		if (sum >= mid) {
        			cnt++;
        			sum = 0;
        		}
        	}
        	
        	if (cnt < K) {
        		high = mid; 
        	} else {
        		low = mid + 1;
        	}
        }
        
        System.out.println(low - 1);                          
	}

}
