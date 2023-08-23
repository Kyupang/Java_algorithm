import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int map[][];
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> houses = new ArrayList<>();
    static int totalMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        totalMin = Integer.MAX_VALUE;

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0, new int[M]);

        System.out.println(totalMin);
    }

    private static void dfs(int index, int selected, int[] selectedChickens) {
        if (selected == M) {
            calculateDistance(selectedChickens);
            return;
        }

        if (index >= chickens.size()) {
            return;
        }

        // 해당 치킨집을 선택하는 경우
        selectedChickens[selected] = index;
        dfs(index + 1, selected + 1, selectedChickens);

        // 해당 치킨집을 선택하지 않는 경우
        dfs(index + 1, selected, selectedChickens);
    }

    private static void calculateDistance(int[] selectedChickens) {
        int semiSum = 0;

        for (int[] house : houses) {
            int minDist = Integer.MAX_VALUE;
            for (int index : selectedChickens) {
                int[] chicken = chickens.get(index);
                minDist = Math.min(minDist, Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]));
            }
            semiSum += minDist;
        }

        totalMin = Math.min(semiSum, totalMin);
    }
}