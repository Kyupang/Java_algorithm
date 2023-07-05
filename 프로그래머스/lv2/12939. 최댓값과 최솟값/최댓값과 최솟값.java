class Solution {
   public String solution(String s) {
	        String answer = "";
	        String[] ans = s.split(" ");
	        
	        int max = Integer.parseInt(ans[0]);
	        int min = Integer.parseInt(ans[0]);
	        
	        for (int i = 0; i < ans.length; i++) {
				if(max < Integer.parseInt(ans[i])) {
					max = Integer.parseInt(ans[i]);
				}
				if(min > Integer.parseInt(ans[i])) {
					min = Integer.parseInt(ans[i]);
				}
			}
	        
	        answer = min +" "+ max;
	        
	        return answer;
	    }
}