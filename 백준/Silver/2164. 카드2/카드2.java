import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
//카드뒤집기 : 큐문제
	public static void main(String[] args) {
		//시간복잡도 O(n)
		
		Scanner sc = new Scanner(System.in);
		Queue<Integer> que = new LinkedList<Integer>();
		
		int N = sc.nextInt();
		
		for(int i = 1; i<N+1 ; i++) {
			que.offer(i);
		}
		
		while(que.size() >1) {
			
			que.poll();
			que.offer(que.poll());
		}
		
		System.out.println(que.poll());
		
		
	}

}
