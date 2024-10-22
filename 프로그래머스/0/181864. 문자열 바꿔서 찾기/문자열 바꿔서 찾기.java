import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        char[] myStrArr = myString.toCharArray();
        for (int i = 0; i < myStrArr.length; i++) {
            if (myStrArr[i] == 'A') {
                myStrArr[i] = 'B';
            } else {
                myStrArr[i] = 'A';
            }
        }
        
        String answerStr = new String(myStrArr);
        
        if (answerStr.contains(pat)) {
            answer = 1;
        }
        
        return answer;
    }
}