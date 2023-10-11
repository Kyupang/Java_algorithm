class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for(int i= 1; i<brown ; i++){
            for(int j =1; j<brown ; j++){
                if(i>= j && i*j == sum){
                    int a = i;
                    int b = j;
                    if((a-2) * (b-2) == yellow ){
                        answer[0] = a;
                        answer[1] = b;
                    }
                    
                }
            }
        }
        
        
        return answer;
    }
}