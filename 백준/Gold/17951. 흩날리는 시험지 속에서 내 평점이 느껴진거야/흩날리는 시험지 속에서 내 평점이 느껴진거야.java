import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int numOfTestPaper = sc.nextInt();
        int targetGroup = sc.nextInt();
        int[] score = new int[numOfTestPaper];
        int low = 0, high = 0;

        for (int i = 0; i < numOfTestPaper; i++) {
            score[i] = sc.nextInt();
            high += score[i];
        }
        high++; 

        while(low < high) {
        	int mid = (low + high) / 2;
        	int cnt = 0, sum = 0;
        	
        	for (int i = 0; i < numOfTestPaper; i++) {
        		sum += score[i];
        		
        		if (sum >= mid) {
        			cnt++;
        			sum = 0;
        		}
        	}
        	
        	if (cnt < targetGroup) {
        		high = mid; 
        	} else {
        		low = mid + 1;
        	}
        }
        
        System.out.println(low - 1);                          
	}

}
