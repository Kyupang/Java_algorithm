import java.util.*;

public class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        String ans = Integer.toString(n);
	        
	        String[] ansArray = ans.split("");
	        
	        for (int i = 0; i < ansArray.length; i++) {
				answer+= Integer.parseInt(ansArray[i]);
			}
	        

	        return answer;
	    }
	}