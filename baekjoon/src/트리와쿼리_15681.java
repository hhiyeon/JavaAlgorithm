/* 트리와 쿼리 - 골드5 - 3/2(수)
가중치와 방향성이 없는 트리
정점 U를 루트로 하는 서브트리에 속한 정점의 수 출력
N 정점의 수
R 루트 번호
Q 쿼리의 수
U V : U와 V를 양 끝점으로 하는 간선이 트리에 속하는 것을 의미
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리와쿼리_15681 {
    static int N, R, Q, U, V; // 정점의 수, 루트 번호, 쿼리의 수, 정점1, 정점2
    static boolean[] visited;
    static ArrayList<Integer>[] node;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        cost = new int[N+1];
        node = new ArrayList[N+1];

        for(int i=0; i<N+1; i++){
            node[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            U = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            node[U].add(V);
            node[V].add(U);
        }

        vertexCost(R);

        for(int i=0; i<Q; i++){
            int query = Integer.parseInt(br.readLine());
            System.out.println(cost[query]);
        }
    }
    public static int vertexCost(int root){
        visited[root] = true;
        int count = 1;

        for(int x : node[root]){
            if(!visited[x]){
                count += vertexCost(x);
            }
        }
        cost[root] = count;
        return cost[root];
    }
}
