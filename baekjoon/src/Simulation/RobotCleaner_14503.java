package Simulation;
/* 로봇청소기 - 14503 - 시뮬레이션 - 골드5 - 1/30(일)
로봇청소기 청소 영역 개수 구하기
N X M 크기
지도의 칸 (r,c)
r 북쪽으로부터 떨어진 칸의 개수
c 서쪽으로부터 떨어진 칸의 개수

1. 현재 위치를 청소한다.
2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색
    a. 왼쪽 방향에 아직 청소하지 않은 공간이 있으면 -> 그 방향으로 회전 후 다음 칸 전진 후 1번부터 진행
    b. 왼쪽 방향에 청소할 공간이 없으면, 그 방향으로 회전하고 2번으로 돌아가기
    c. 네 방향 모두 이미 청소가 되어있거나 벽인 경우는 -> 바라보는 방향을 유지하고 한 칸 후진 후 2번으로 돌아가기
    d. 네 방향 모두 이미 청소 or 벽 -> 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동 멈추기
* 빈칸 0 벽 1
북뽁 0 동쪽 1 남쪽 2 서쪽 3
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RobotCleaner_14503 {
    static class Point {
        int x;
        int y;
        int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static int N,M;
    static int r,c,d;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static Queue<Point> Q = new LinkedList<>();
    static int[][] map;
    static boolean[][] clean;
    static int cleanCnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        clean = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        Q.offer(new Point(r, c, d)); // 로봇의 시작 지점
//        clean[r][c] = true;
//        cleanCnt = 1;

        BFS(); // BFS에서 가장 큰 값 찾기

        System.out.println(cleanCnt); // 청소된 방의 개수 출력

    }


    public static void BFS(){
        clean[r][c] = true;
        Q.offer(new Point(r, c, d));

        while(!Q.isEmpty()){
            Point p = Q.poll();
            int x = p.x;
            int y = p.y;
            int d = p.d;
            int nextDir = d;

            //    1. 현재 위치를 청소한다.
//2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색
//    a. 왼쪽 방향에 아직 청소하지 않은 공간이 있으면 -> 그 방향으로 회전 후 다음 칸 전진 후 1번부터 진행
//    b. 왼쪽 방향에 청소할 공간이 없으면, 그 방향으로 회전하고 2번으로 돌아가기
//    c. 네 방향 모두 이미 청소가 되어있거나 벽인 경우는 -> 바라보는 방향을 유지하고 한 칸 후진 후 2번으로 돌아가기
//    d. 네 방향 모두 이미 청소 or 벽 -> 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동 멈추기
//* 빈칸 0 벽 1
//    북뽁 0 동쪽 1 남쪽 2 서쪽 3

            boolean isClean = false; // 청소되지 않은 구역
            for(int i=0; i<4; i++){
                nextDir = leftDir(nextDir);
                int tx = x + dx[nextDir]; // 상하좌우 이동 x좌표
                int ty = y + dy[nextDir]; // 상하좌우 이동 y좌표

                if(tx >= 0 && ty >= 0 && tx < N && ty < M){
                    // 인접한 칸에서 청소 안한 구역 찾기
                    if(!clean[tx][ty] && map[tx][ty]==0){
                        isClean = true; // 청소
                        clean[tx][ty] = true; // 청소
                        cleanCnt++;
                        Q.offer(new Point(tx, ty, nextDir));
                        break;
                    }
                }
            }

            if(!isClean){ // 청소가 안되있는 경우 = 상하좌우로 가지 않았다는 것
                nextDir = backDir(d);
                int tx = x + dx[nextDir]; // 뒤로 후진
                int ty = y + dy[nextDir]; // 뒤로 후진

                if(tx >= 0 && ty >= 0 && tx < N && ty < M) {
                    if(map[tx][ty]==0) { // 뒤에가 벽이 아닌 경우
                        Q.offer(new Point(tx, ty, d));
                    }
                }
            }
        }
    }

    private static int leftDir(int d){
        switch (d) {
            case 0:
                return 3;
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
            return 2;
        }
        return 0;
    }

    private static int backDir(int d){
        switch (d) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 0;
            case 3:
                return 1;
        }
        return 0;
    }
}
