package DFS_BFS;
/* 토마토 - BFS - 골드5
* 6 4 입력 -> 4행 6열
* board(입력 배열), dis(날짜) 배열
* 큐에다가 익은 토마토 1 (익은 토마토의 시작지점)
* 시작위치가 여러개일수도 있음 동시다발적으로 퍼져나가게
* -> 1이 발견된 좌표 탐색하다가 발견되면 queue에다가 넣기
* -> 또 읽어들이다가 발견하면 queue에 넣기
* 0일때만 이동 가능
* 큐의 맨 앞 값 빼고 주변 애들 중에 0 인애들 board 에 방문체크(1) 하고 큐에넣기
* dis 배열에 방문체크한 애들 이전 값에 +1
* 이 과정 반복하기
* */

import java.io.*;
import java.util.*;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;

public class Tomato_7576 {
    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int[][] map, day;
    static Queue<Point> Q = new LinkedList<>();
    static int M,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M]; // 토마토 상자
        day = new int[N][M]; // 날짜 체크

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); // 토마토 입력
                if(map[i][j] == 1){ // 시작 지점
                    Q.offer(new Point(i, j)); // 시작지점 큐에 넣기
                    day[i][j] = 0; // 시작지점에 0 입력
                }
            }
        }
        // BFS 돌린 후 day 에서 가장 큰 값 찾기
        BFS();

        // 처음부터 모든 토마토가 익은 경우 0 출력, 토마토가 모두 익지 못하는 상황 -1 출력
        boolean flag = true;
        int answer = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){ // 익지 않는 토마토가 있다.
                    flag = false; // flag 변환
                }
            }
        }
        if(flag){ // 모든 토마토가 익을 경우 -> 가장 큰 날짜를 찾는다.
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    answer=Math.max(answer, day[i][j]);
                }
            } // 처음부터 토마토가 다 익었으면 어차피 MaxDay = 0
            // 이외의 경우 day 의 최대 값을 출력 가능하다.
            System.out.println(answer);
        } else { // 토마토가 익지 않았을 경우
            System.out.println(-1); // -1 출력
        }
    }

    /* BFS 수행하기
     * map 에서 0 일때만 이동 가능 (-1은 토마토가 없음)
     * 큐의 맨 앞 값을 빼고 주변 애들 중에 0 인 애들 map 에 방문체크(1) 하고 큐에넣기
     * day 배열에 방문체크한 애들 이전 값에서 +1
     * 이 과정 반복하기 */
    public static void BFS(){
        while(!Q.isEmpty()){ // 큐가 꽉찰때까지 반복
            Point p = Q.poll(); // 맨 앞 값을 경로 p에 저장
            for(int i=0; i<4; i++){ // 연결된 곳을 순회
                int ty = p.y + dy[i]; // 꺼낸 값 보다 상하좌우 y좌표
                int tx = p.x + dx[i]; // 꺼낸 값 보다 상하좌우 x좌표
                if(0 <= ty && ty < N && 0 <= tx && tx < M && map[ty][tx]==0){
                    // 공간에서 벗어나지 않는 애들만 수행
                    // -1인 곳은 이동하지 못한다. 이동 가능한 곳만 수행
                    map[ty][tx] = 1; // 익은 토마토를 1으로 체크하고
                    Q.offer(new Point(ty, tx)); // 큐에 익은 토마토 경로를 넣는다.
                    day[ty][tx] = day[p.y][p.x]+1; // 이전의 날짜에서 +1을 더해 현재 경로에 날짜를 넣어준다.
                }
            }
        }
    }
}
