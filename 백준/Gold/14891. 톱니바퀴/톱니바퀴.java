import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] gear;
	static int k;
	static int gearN;
	static int turn;
	static int[] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		gear = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				char a = line.charAt(j);
				gear[i][j] = Character.getNumericValue(a);
			}
		}

		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			gearN = Integer.parseInt(st.nextToken()) - 1;
			turn = Integer.parseInt(st.nextToken());

			d = new int[4];
			d[gearN] = turn;

			checkDir(gearN);
			gearTurn();
		}
		
		int sum = 0;
		
		if(gear[0][0] == 1) sum+=1;
		if(gear[1][0] == 1) sum+=2;
		if(gear[2][0] == 1) sum+=4;
		if(gear[3][0] == 1) sum+=8;
		
		System.out.println(sum);

	}

	private static void checkDir(int gearN) {
		// 톱니의 좌측
		for (int i = gearN - 1; i >= 0; i--) {
			if (gear[i][2] != gear[i + 1][6]) {
				d[i] = -d[i + 1];
			} else {
				break;
			}
		}

		// 톱니의 우측
		for (int i = gearN + 1; i < 4; i++) {
			if (gear[i][6] != gear[i - 1][2]) { 
				d[i] = -d[i - 1];
			} else {
				break;
			}
		}
	}

	private static void gearTurn() {
		for (int i = 0; i < 4; i++) {
			// 좌측으로 회전
			if(d[i] == -1) {
				int temp =gear[i][0];
				for(int k = 0; k<7 ; k++) {
					gear[i][k] = gear[i][k+1];
				}
				gear[i][7] = temp;
				
			}
			// 우측으로 회전
			else if( d[i] == 1) {
				int temp = gear[i][7];
				for(int j=7; j>0; j--) {
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = temp;
			}
		}


	}
}
