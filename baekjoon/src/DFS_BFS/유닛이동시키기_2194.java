package DFS_BFS;
/*유닛 이동시키기 - 그래프탐색 - 2194 - 골드5
* N * M 크기의 맵
* A * B 크기의 유닛
* S : 시작점
* E : 끝점
* 색이 칠해진 부분 : 장애물
* 유닛을 목적지까지 움직이기 위해 필요한 최소의 이동 횟수 구하기
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유닛이동시키기_2194 {
    static int N, M, A, B, K;
    static int trapRow, trapCol;
    static int startRow, startCol;
    static int lastRow, lastCol;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int[][] map;
    static int[][] check;
    static int count = 0;
    static Queue<Point> Q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        check = new int[N+1][M+1];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            trapRow = Integer.parseInt(st.nextToken());
            trapCol = Integer.parseInt(st.nextToken());
            map[trapRow][trapCol] = 1;
        }

        // 시작점이랑 마지막점 위치는 제일 왼쪽 위의 한 점만 입력
        st = new StringTokenizer(br.readLine());
        startRow = Integer.parseInt(st.nextToken());
        startCol = Integer.parseInt(st.nextToken());
        Q.offer(new Point(startRow, startCol));
        check[startRow][startCol] = 1;

        st = new StringTokenizer(br.readLine());
        lastRow = Integer.parseInt(st.nextToken());
        lastCol = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(count);
    }

    static void bfs(){
        while(!Q.isEmpty()){
            int size = Q.size();
            for(int i=0; i<size; i++){
                Point p = Q.poll();
                if(p.x == lastRow && p.y == lastCol){ // 도착점일 경우 break
                    break;
                }
                for(int d=0; d<4; d++){
                    int tx = p.x + dx[d];
                    int ty = p.y + dy[d];

                    if((0<=tx && tx < N && 0 <= ty && ty < M) && checkPoint(tx, ty)){
                        Q.offer(new Point(tx, ty));
                    }
                }
            }
            count++;
        }
    }


    static boolean checkPoint(int x, int y){
        System.out.println(x+ " "+ y);
        for(int i=y; i<y+A; i++){
            for(int j=x; j<x+B; j++){
                if(i>N || j>N || i<=0 || j<=0 || check[i][j]==1 || map[i][j]==1){
                    return false;
                }
            }
        }
        check[x][y] = 1;
        return true;
    }
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
