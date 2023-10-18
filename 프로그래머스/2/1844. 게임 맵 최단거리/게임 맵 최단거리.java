import java.util.*;
class Solution {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static boolean visited[][];

    public int solution(int[][] maps) {  //처음에 그래프를 받습니다.
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        
        BFS(0,0,n,m,maps);
        
        
        return !visited[n-1][m-1] ? -1 : maps[n-1][m-1];
    }
    
    private static void BFS(int r, int c, int N, int M, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new int[] {r,c});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int k = 0; k< 4 ; k++){
                int nr = now[0] + dr[k];
                int nc = now[1] + dc[k];
                
                if(nr>=0 && nc>=0 && nr< N &&nc<M){
                    if(!visited[nr][nc] && maps[nr][nc] !=0){
                        visited[nr][nc] = true;
                        maps[nr][nc] = maps[now[0]][now[1]]+1;
                        q.offer(new int[] {nr,nc});
                    }
                }
            }
        }
    } 
    
}