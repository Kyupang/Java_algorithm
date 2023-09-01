
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int zeroCount = 0;
		int oneCount = 0;
		
		if(s.charAt(0) == '1') {
			oneCount++;
		}else {
			zeroCount++;
		}
		
		for(int i=1; i< s.length() ; i++) {
			if(s.charAt(i) != s.charAt(i-1)) {
				if(s.charAt(i) =='1') {
					oneCount++;
				}else {
					zeroCount++;
				}
			}
		}
		
		
		System.out.println(Math.min(oneCount, zeroCount));
	}

}
