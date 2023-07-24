import java.util.Scanner;

public class Main {
//평균구하기 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		 
		String input = sc.nextLine();
		String [] inputs = input.split(" ");
		
		int[] aNum = new int[inputs.length];
		for(int i = 0; i < inputs.length; i++) {
			aNum[i] = Integer.parseInt(inputs[i]);
		}
		
		int maxNum = aNum[0];
		double sum = 0;
		
		
		for(int x : aNum) {
			if(maxNum < x) {
				maxNum = x;
			}
		}
		
		
		for(int i = 0; i< aNum.length ; i++) {
			sum += (double)aNum[i] / maxNum * 100;
		}
		
		double result = (double)sum / aNum.length;
		
		System.out.println(result);
		
		sc.close();
	}
}