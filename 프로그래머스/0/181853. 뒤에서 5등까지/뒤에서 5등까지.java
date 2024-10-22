import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[5];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < num_list.length; i++) {
            pq.offer(num_list[i]);
        }
        
        for (int i = 0; i < 5; i++) {
            if (!pq.isEmpty()) {
                answer[i] = pq.poll();
            }
        }
        
        return answer;
    }
}