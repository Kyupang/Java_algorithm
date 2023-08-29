import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i= 0; i< works.length ; i++){
            queue.offer(works[i]);
        }
        
        for(int i=0; i< n ; i++){
            int max = queue.poll();
            
            if(max<=0) break;
            
            queue.offer(max-1);
        }
        
        long tired = 0;
        
        while(!queue.isEmpty()){
            int k = queue.poll();
            tired += k*k;
        }
        
        
        
        return tired;
    }
}