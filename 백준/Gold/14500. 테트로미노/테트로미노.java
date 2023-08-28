
import java.util.Scanner;

public class Main{
    static int N, M, ans;
    static int[][] map;
    static int[] dx = {0,1, 0, -1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visit;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visit[i][j] = false;
                check(i, j);
            }
        }
        System.out.println(ans);

    }

    static void dfs(int x, int y, int cnt, int sum) {

        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) {
                continue;
            }

            visit[nx][ny] = true;
            dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
            visit[nx][ny] = false;
        }
    }

    static void check(int x, int y) {
        if (x < N - 2 && y < M - 1) // 밑으로 두개 ㅏ
            ans = Math.max(ans, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1]);

        if (x < N - 2 && y > 0) // ㅓ
            ans = Math.max(ans, map[x][y] + map[x + 1][y] + map[x+ 2][y] + map[x+ 1][y - 1]);

        if (x < N - 1 && y < M - 2) //ㅜ 
            ans = Math.max(ans, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1]);

        if (x > 0 && y < M - 2) //ㅗ
            ans = Math.max(ans, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 1]);
    }


}
