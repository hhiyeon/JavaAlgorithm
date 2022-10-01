package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** DFS와 BFS - 문제이름 그대로 - 실버2 - 1/26(수)
 * N 정점의 개수
 * M 간선의 개수
 * V 탐색을 시작할 정점의 번호
 * M 개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
 * 입력으로 주어지는 간선은 양방향
 */

public class DFSnBFS_1260 {
//    static class Point {
//        int data;
//        LinkedList<Point> adjacent;
//        boolean type;
//
//        public Point(int data) {
//            this.data = data;
//            this.type = false;
//            adjacent = new LinkedList<>();
//        }
//    }
    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());;
            int b = Integer.parseInt(st.nextToken());;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);
        //System.out.println();
        sb.append('\n');

        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);
//        point = new Point[M];
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int data, adjacent;
//            data = Integer.parseInt(st.nextToken());
//            point[i] = new Point(data);
//
//            Point
//        }

        /* DFS - 가장 깊은 곳으로 들어가서 찾는 해를 찾을 때 까지 되돌아가는 기법
        * 1. 탐색 시작 노드를 스택에 삽입하고 방문 처리
        * 2. 스택의 top 에서 방문하지 않은 인접 노드(white)가 있으면
        *   - 여러 노드가 여러개일 경우 번호가 낮은 순서부터 처리
        *       - 인접 노드를 스택에 넣고 방문 처리(Gray)
        *   - (없으면) 스택에서 최상단 노드 꺼내기
        * 3. 2번의 과정을 수행할 수 없을 때까지 반복
        * */

    }
    public static void dfs(int i) {
        visited[i] = true; // 시작 노드를 삽입
        //System.out.print(i + " "); // 출력
        sb.append(i).append(' ');

        for (int j = 1; j < graph.length; j++) {
            if (graph[i][j] == 1 && !visited[j]) { // 현재 위치의 값이 1이고, 방문하지 않은경우
                dfs(j); // dfs 반복
            }
        }
    }

    /* BFS - 가장 가까운 노드부터 탐색
    * 1. 탐색 시작 노드를 큐에 삽입하고 방문 처리
    * 2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리
    *   - 여러 노드가 있을 경우, 숫자가 작은 노드부터 먼저 큐에 삽입
    * 3. 2번의 과정을 반복
    *
    * */
    public static void bfs(int i){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(i); // 탐색 시작 노드 삽입
        visited[i] = true; // 방문 처리

        while(!queue.isEmpty()){
            int value = queue.poll();
            sb.append(value).append(' ');
            //System.out.print(value+" ");
            for (int j = 1; j < graph.length; j++) {
                if(graph[value][j] == 1 && !visited[j]){
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
        //sb.append('\n');
    }
}
