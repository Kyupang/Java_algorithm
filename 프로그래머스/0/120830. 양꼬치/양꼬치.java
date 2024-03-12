class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        int yang = n * 12000;
        int um = k * 2000;
        int service = -((n / 10) * 2000);
        
        answer = yang + um + service;
        return answer;
    }
}