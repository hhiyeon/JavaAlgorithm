package DFS_BFS;
/* 작업 - 깊이우선탐색 - 21937 - 실버1*/

/**/

import Bruteforcing.미풀이_NumberBaseBall_2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Task_21937 {

    static int N, M; // 작업 개수, 순서 정보 개수
    static int a, b; // 작업A, 작업B
    static ArrayList<Integer>[] list;
    static int X, count; // 작업X, 작업 개수
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

//            list[a].add(b);
            list[b].add(a);
        }

        X = Integer.parseInt(br.readLine());
        count = 0;

        dfs(X);
        System.out.println(count);
    }

    public static void dfs(int X){
        visited[X] = true;

        for(int i = 0; i < list[X].size(); i++){
            int num = list[X].get(i);
            if(!visited[num]){
                // visited[i] = true;
                count++;
                dfs(num);
            }
        }
    }
}
