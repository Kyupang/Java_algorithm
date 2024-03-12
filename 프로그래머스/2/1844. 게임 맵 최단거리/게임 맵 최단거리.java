import java.util.*;
class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public int solution(int[][] maps) { 
        int rowSize = maps.length;
        int colSize = maps[0].length;
        
        boolean[][] visited = new boolean[rowSize][colSize];
        
        findRoute(visited, maps);
        
        return !visited[rowSize - 1][colSize - 1] ? -1 : maps[rowSize - 1][colSize - 1]; 
    }
    
    private static void findRoute(boolean visited[][], int[][] maps) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0, 0});
        visited[0][0] = true;
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            
            for (int k = 0; k < 4; k++) {
                int nr = now[0] + dr[k];
                int nc = now[1] + dc[k];
                
                if (nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[0].length)
                    continue;                
                if (visited[nr][nc] || maps[nr][nc] == 0)
                    continue;
                
                visited[nr][nc] = true;
                maps[nr][nc] = maps[now[0]][now[1]] + 1;
                que.offer(new int[] {nr, nc});
            }
        }
    }
}