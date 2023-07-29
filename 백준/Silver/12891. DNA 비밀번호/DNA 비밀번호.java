import java.io.*;
import java.util.*;

public class Main {
	// DNA 비밀번호 
	// O(n)의 시간복잡도를 가진다. 
	
	static int[] checkArr;
	static int[] myArr;
	static int semiCount;
	
	public static void main(String[] args) throws IOException {
		// checkArr 와 myArr 의 속해진 값을 비교 하므로써 
		// 맞으면 한문자당의 checkScret ++;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] A = new char[S];
		A = br.readLine().toCharArray();
		
		semiCount = 0;
		int resultCount = 0;
		
		myArr = new int[4];		
		checkArr = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<4 ; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] == 0) semiCount++;
		}
		
		//슬라이딩윈도우 
		//범위를 고정하여 인텍스 두개만 이동한다.
		//빠지고 들어가는애만 
		//1. 처음 행위는 맞는건 ++;
		for(int i =0 ; i<P ; i++) {
			Add(A[i]);
		}
		
		if(semiCount ==4) {
			resultCount++;
		}
		
		//2. 옆으로 이동하며 맞으면 ++ 뺐던게 맞으면 --;
		for(int i=P ; i<S ; i++) {
			// i = P 부터 P+1 P+2 ... 
			//j =0 부터 P+(1,2,3)-P 순으로 이동한다.
			int j = i-P;
			Add(A[i]);
			Remove(A[j]);
			if(semiCount == 4) resultCount++;
		}
		
		System.out.println(resultCount);
		
		br.close();
		
		//결국 슬라이딩 윈도우에서 필요한 것은 처음 행위와 
		// 움직였을 때의 행위가 다르다는 것 
		// 처음 행위에서는 뺄것도 없고 인덱스도 처음부터이지만 
		// 두번째 행위부터는 오른쪽 끝의 인덱스는 올리고 
		// 왼쪽 끝의 인덱스도 올려야하니까 
		// 두개의 인덱스를 다루는 배열로 진행을 해야함. 
	}

	private static void Remove(char c) {
		// 뺀게 이 문자열중에 하나라면 --해야함.
		switch(c) {
		case 'A' :
			if(checkArr[0] == myArr[0]) semiCount--;
			myArr[0]--;
			break;
		case 'C' :
			if(checkArr[1] == myArr[1]) semiCount--;
			myArr[1]--;
			break;
		case 'G' :
			if(checkArr[2] == myArr[2]) semiCount--;
			myArr[2]--;
			break;
		case 'T' :
			if(checkArr[3] == myArr[3]) semiCount--;
			myArr[3]--;
			break;
		}
	}

	private static void Add(char c) {
		switch(c) {
		case 'A' :
			myArr[0]++;
			if(checkArr[0] == myArr[0]) semiCount++;
			break;
		case 'C' :
			myArr[1]++;
			if(checkArr[1] == myArr[1]) semiCount++;
			break;
		case 'G' :
			myArr[2]++;
			if(checkArr[2] == myArr[2]) semiCount++;
			break;
		case 'T' :
			myArr[3]++;
			if(checkArr[3] == myArr[3]) semiCount++;
			break;
		}
	}
}