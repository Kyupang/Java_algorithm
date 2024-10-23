import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        char[] sArr = my_string.toCharArray();
        for (char ch : sArr) {
            if (ch >= 'A' && ch <= 'Z') {
                answer[ch - 'A']++;
            } else if (ch >= 'a' && ch <= 'z') {
                answer[ch - 'a' + 26]++;
            }
            
        }
        
        return answer;
    }
}