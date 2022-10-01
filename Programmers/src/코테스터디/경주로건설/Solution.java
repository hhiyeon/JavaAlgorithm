package 코테스터디.경주로건설;
/* 경주로 부지 N X N
* 격자 칸 0 : 비어있음
* 격자 칸 1 : 해당 칸이 벽으로 채워져 있음
* 경주로 출발점 (0,0)
* 경주로 도착점 (N-1, N-1)
* 직선도로(상하 또는 좌우로 연결) 100원
* 코너(직선도로가 서로 직각으로 만나는 지점) 500원
* 경주로를 건설하는 데 필요한 최소 비용 계산
* */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point{
        int x, y, cost, dir;

        public Point(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
    static int N;
    static Queue<Point> queue = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int answer = Integer.MAX_VALUE;
    public int solution(int[][] board) {
        N = board.length;
        visited = new boolean[N][N];
        bfs(board);

        return answer;
    }

    public static void bfs(int[][] board){
        queue.add(new Point(0,0,0,-1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(p.x == N-1 && p.y == N-1){
                answer = Math.min(answer, p.cost);
            }

            for(int d=0; d<4; d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(0<=nx && nx < N && 0<=ny && ny < N && board[nx][ny]!=1){
                    int sum = 0;
                    if(p.dir == -1 || p.dir == d){
                        sum = p.cost + 100;
                    } else {
                        sum = p.cost + 600;
                    }

                    if(!visited[nx][ny] || board[nx][ny] >= sum){
                        visited[nx][ny] = true;
                        board[nx][ny] = sum;
                        queue.add(new Point(nx, ny, sum, d));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] board = {{0,0,1,0}, {0,0,0,0}, {0,1,0,1}, {1,0,0,0}};
        System.out.println(T.solution(board));
    }
}
