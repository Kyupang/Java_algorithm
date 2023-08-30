
import java.util.Collections;
import java.util.PriorityQueue;


class Solution {
    public int[] solution(String[] operations) {
       int[] answer = new int[2];
		PriorityQueue<Integer> pqa = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pqd = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0; i< operations.length; i++) {
			String[] split = operations[i].split(" ");
			
			if(split[0].equals("I")) {
				pqa.offer(Integer.parseInt(split[1]));
				pqd.offer(Integer.parseInt(split[1]));
			}else if(split[0].equals("D")) {
				if(split[1].equals("1") && !pqa.isEmpty()) {
					int temp = pqd.poll();
					pqa.remove(temp);
				}else if(split[1].equals("-1") && !pqd.isEmpty()) {
					int temp = pqa.poll();
					pqd.remove(temp);
				}
			}
		}
		
		if(!pqa.isEmpty()) {
			answer[0] = pqd.poll();
			answer[1] = pqa.poll();
		}else {
			answer[0] =0;
			answer[1] =0;
		}
		

		return answer;
    }
}