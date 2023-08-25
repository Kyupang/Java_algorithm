
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<Integer> primeList = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }
        
        // ArrayList를 배열로 변환
        int[] primeArray = new int[primeList.size()];
        for (int i = 0; i < primeList.size(); i++) {
            primeArray[i] = primeList.get(i);
            
        }
        
        int start = 0;
		int end = -1; // 처음에 아무것도 안선택한 경우 
		int sum = 0;
		int count = 0;
        
		
		while(start < primeArray.length) {
			if(sum == N) {
				count++;
				sum -= primeArray[start]; // Update sum and move start
                start++;
			}else if(sum < N) {
				if (end + 1 < primeArray.length) {
		            end++;
		            sum += primeArray[end];
		        } else {
		            break; // 배열의 범위를 벗어난 경우 루프 종료
		        }
			}else if(sum > N) {
				sum-= primeArray[start];
				start++;
			}
		}
		
		
		System.out.println(count);
		
		sc.close();
    }

    // 소수 판별 함수
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for(int i = 2; i<= Math.sqrt(num) ; i++) {
        	if(num%i == 0) {
        		return false; 
        	}
        }
        return true;
    }
}

