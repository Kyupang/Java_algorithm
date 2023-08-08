import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        // 항상 자기 자신으로 들어가면 1이 있으니 괜춘 
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i, n, computers);
                answer++;
            }
        }

        return answer;
    }

    private static void DFS(int node, int n, int[][] computers) {
        if(visited[node])return;
        
        visited[node] = true;
        
        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (computers[node][neighbor] == 1 && !visited[neighbor]) {
                DFS(neighbor, n, computers);
                //이웃 노드에서 DFS 다시 돌려 
            }
        }
    }
    
}
