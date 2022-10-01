package DFSBFS기초.경로탐색_인접행렬12;

import java.util.Scanner;
/*

5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

* */
// 방향 그래프
// 1번에서 N번 정점으로 가는 모든 경로의 가지 수 출력
public class Solution {
    static int n, m, answer = 0;
    static int[][] graph; // 정점 체크
    static int[] ch; // 방문 체크
    public void DFS(int v){
        if(v==n){
            answer++;
        } else {
            for(int i=1; i<=n; i++){
                if(graph[v][i]==1 && ch[i]==0){ // v번 행에서 1~n까지 찾을 수 있는 정점 찾기
                    ch[i] = 1; // 방문 체크
                    DFS(i);
                    ch[i] = 0; // DFS 실행 후에 스택 프레임을 통해 다시 되돌아 올때 방문 풀어주기
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        n = 5; // 정점의 수
        m = 9; // 간선의 수
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
