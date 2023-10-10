class Solution {
    public long solution(int n, int[] times) {
        
        long max =  (long)times[times.length -1] * n;
        long min = 1;
        long sum;
        long answer = max;
        
        while(min <= max){
            sum =0;
            long mid = (max + min) /2;
            
            for(long time : times){
                sum += mid/ time;
            }
            
            if(sum >=n){
                max = mid-1;
                answer = mid;
            }else{
                min = mid+1;
            }
        }
        
        
        return answer;
        
    }
}