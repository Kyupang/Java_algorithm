import java.util.*;
import java.io.*;

class Solution {
   Set<Integer> set = new HashSet<Integer>();
	
	public int solution(String numbers) {
		int count = 0;
		
		// 재귀로 모든 조합 넣기 
		// set에 넣자 중복있을 수 있으니 
		recursive("",numbers);
		
		// 소수인 것 고르기 
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			int num = it.next();
			
			if(isPrime(num)) count++;
		}
		// 카운트 쁠쁠
		
		
		System.out.println(count);
		return count;
	}
	
	private boolean isPrime(int num) {
		if(num <= 1) return false;
		
		for(int i=2 ; i<= Math.sqrt(num) ; i++) {
			if(num%i ==0) {
				return false;
			}
		}
		
		return true;
	}

	private void recursive(String comb, String others) {
		
		if(!comb.equals("")) {
			set.add(Integer.parseInt(comb));
		}
		
		for(int i =0 ; i< others.length(); i++) {
			recursive(comb + others.charAt(i), others.substring(0,i) + others.substring(i+1));
		}
		
	}
}