import java.util.Arrays;
import java.util.Scanner;

public class Main {
//타깃 데이터 탐색
// 중앙값 비교를 통한 대상 축소 
// 정렬되어있는 상태에서 원하는 값을 찾아내는 알고리즘 
// 시간복잡도 O(logn)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i< N ; i++) {
			A[i] = sc.nextInt();
		}
		
		Arrays.sort(A);
		
		int M = sc.nextInt();
		for(int i=0; i< M; i++) {
			boolean find = false;
			int target = sc.nextInt();
			
			//이진탐색 
			
			int start = 0;
			int end = A.length -1;
			while(start <= end) {
				int mid = (start + end) / 2;
				int mid_val = A[mid];
				
				if(mid_val > target) {
					end = mid -1;
				}else if (mid_val < target) {
					start = mid+1;
				}else {
					find = true;
					break;
				}
			}
			
			if(find)System.out.println(1);
			else System.out.println(0);
		}
 	}

}