package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 구슬탈출 - 시뮬레이션, bfs - 골드2 - 2/19(토)
* 빨간 구슬, 파란 구슬
* 세로 N 가로 M
* 방향 : 왼쪽, 오른쪽, 위쪽, 아래쪽
* 10번 이하로 빨간 구슬을 구멍을 통해 뺄 수 있는지 구하는 프로그램
* */
public class 구슬탈출_13459 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> redQ = new LinkedList<>();
    static Queue<Point> blueQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'B') { // 파란 구슬
                    blueQ.add(new Point(i, j));
                    board[i][j] = '.';
                }
                if (board[i][j] == 'R') { // 빨간 구슬
                    redQ.add(new Point(i, j));
                    board[i][j] = '.';
                }
                board[i][j] = str.charAt(j);
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        // Q.add(new Point[]{red, blue});
        int count = 0;
        while (!redQ.isEmpty() && count++ < 10) {
            int size = redQ.size();
            for (int i = 0; i < size; i++) {
                Point R = redQ.poll();
                Point B = blueQ.poll();
                Point blue = new Point(0, 0);
                Point red = new Point(0, 0);
                for (int d = 0; d < 4; d++) {
                    move(R.x, R.y, d);
                    move(B.x, B.y, d);
                    if (board[red.x][red.y] == '0' && board[blue.x][blue.y] != '0') {
                        return 1;
                    } else if (board[blue.x][blue.y] == '0') {
                        continue;
                    } else if (red.y == blue.y && red.x == blue.x) {
                        if (d == 0) {
                            if (R.y < B.y) {
                                red.y -= 1;
                            } else {
                                blue.y -= 1;
                            }
                        } else if (d == 1) {
                            if (R.y > B.y) {
                                red.y += 1;
                            } else {
                                blue.y += 1;
                            }
                        } else if (d == 2) {
                            if (R.x < B.x) {
                                red.x -= 1;
                            } else {
                                blue.x -= 1;
                            }
                        } else if (d == 3) {
                            if (R.x > B.x) {
                                red.x += 1;
                            } else {
                                blue.x += 1;
                            }
                        }
                        redQ.add(red);
                        blueQ.add(blue);
                    }
                }
            }
        }
        return count;
    }
    static void move(int x, int y, int d){
        while(true){
            int tx = x + dx[d];
            int ty = y + dy[d];

            if(tx<0 || ty <0 || tx >M || ty > N){
                break;
            }
            if(board[tx][ty] == '#'){
                break;
            }
            x = tx;
            y = ty;
            if(board[tx][ty] == '0'){
                break;
            }
        }
    }
}
