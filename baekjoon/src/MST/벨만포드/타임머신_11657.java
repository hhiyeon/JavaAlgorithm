package MST.벨만포드;

/* 타임머신 - 최단거리 알고리즘(음수) - 벨만포드알고리즘 - 골드4 - 1/24(월)&1/25(화)
 * N 개의 도시
 * 한 도시에서 다른 도시에 도착하는 버스 M 개
 * 각 버스는 A(시작도시), B(도착도시), C(이동시간)
 * C(음수도 가능) -> 벨만포드
 * C = 0 // 순간 이동을 하는 경우, C < 0 : 타임머신으로 시간을 되돌아가는 경우
 * 1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간 구하기
 * */

import java.io.*;
import java.util.*;

public class 타임머신_11657 {
    static class Point {
        int from;
        int to;
        int time;

        public Point(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
    static int N, M; // 도시의 개수, 한 도시에서 다른 도시에 도착하는 버스 개수
    static Point[] arr;
    static long[] cost;
    static int A, B, C; // 버스 노선의 정보
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cost = new long[N + 1];
        arr = new Point[M + 1];
        for(int i = 1 ; i<=N ; i++) {
            cost[i] = INF;
        }

        for(int i = 1 ; i <= M ;i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            arr[i] = new Point(A, B, C);
        }

        findShortestPath(1);
        boolean isNegativeCycle = findNegativeCycle();

        if(isNegativeCycle) {
            bw.write("-1" + "\n");
            bw.flush();
            bw.close();
            return;
        }

        for(int i = 2 ; i<= N ; i++) {
            if(cost[i] == INF) {
                bw.write("-1" + "\n");
            } else {
                bw.write(cost[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void findShortestPath(int start) {
        cost[start] = 0;
        for(int i = 1 ; i <= N - 1 ; i++) {
            for(int j = 1 ; j <= M ; j++) {
                Point nowEdge = arr[j];
                if(cost[nowEdge.from] != INF && cost[nowEdge.to] > cost[nowEdge.from] + nowEdge.time) {
                    cost[nowEdge.to] = cost[nowEdge.from] + nowEdge.time;
                }
            }
        }
    }

    public static boolean findNegativeCycle() {
        for(int j = 1 ; j <= M ; j++) {
            Point nowEdge = arr[j];
            if(cost[nowEdge.from] != INF && cost[nowEdge.to] > cost[nowEdge.from] + nowEdge.time) {
                return true;
            }
        }
        return false;
    }
}
