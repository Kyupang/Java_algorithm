import java.util.*;
import java.io.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
		int count =0;
        dfs("",numbers);
        
        ArrayList<Integer> list = new ArrayList<Integer>(set);
        for(int i = 0; i< list.size(); i++){
            if(isPrime(list.get(i))){
                count++;
            }
        }
        
		return count;
	}
    private static boolean isPrime(int num){
        if(num <= 1) return false;
        
        for(int i=2 ; i<= Math.sqrt(num) ; i++){
            if(num % i ==0){
                return false;
            }
        }
        return true;
    }
    
    private static void dfs(String comb , String numbers){
        int n = numbers.length();
        
        if(!comb.equals("")){
            set.add(Integer.parseInt(comb));
        }
        
        for(int i=0; i< n ; i++){
            dfs(comb+numbers.charAt(i), numbers.substring(0,i) + numbers.substring(i+1,n));
        }
    }
}