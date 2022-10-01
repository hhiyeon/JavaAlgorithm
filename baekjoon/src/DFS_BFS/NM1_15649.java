package DFS_BFS;

import java.util.Scanner;

/* N과 M (1) - 백트래킹 - 실버3 - 2/7(월)
* 자연수 N, M이 주어졌을 때, 조건을 만족하는 길이가 M인 수열을 모두 구하기
* 조건 : 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
* */
public class NM1_15649 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N 까지의 자연수
        M = sc.nextInt();   // 조건을 만족하는 수열의 길이 M
        arr = new int[N+1];
        visited = new boolean[N+1];

        dfs(0, N, M);
    }
    public static void dfs(int idx, int N, int M){
        if(idx == M) { // 깊이가 M과 같아지면 탐색과정에서 담았던 배열 출력
            for (int x : arr) {
                if(x != 0) System.out.println(x);
            }
            return;
        }
        for(int i=0; i<N; i++){
            // 노드를 방문하지 않은 곳이면
            if(visited[i]) continue;
            // 해당 노드를 방문 상태로 변경하고
            visited[i] = true;
            // 해당 깊이를 Idx로 해서 i+1 값 저장
            arr[idx] = i+1;
            // 다음 자식 노드 방문을 위해 깊이를 1 증가하고 재귀 호출
            dfs(idx+1, N, M);
            // 자식 노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
            visited[i] = false;
        }
    }
}
