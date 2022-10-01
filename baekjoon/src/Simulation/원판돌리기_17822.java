package Simulation;
/* 원판 돌리기 - 시뮬레이션 - 골드3 - 2/26(토)
원판의 반지름이 i, i번째 원판이라고 한다.
각각의 원판에 M개의 수가 적혀있고, i번째 원판의 j번째 위치를 (i,j)로 표현
원판을 T번 회전시킬 때 i번째 회전할 때 사용하는 변수 xi, di, ki
번호가 xi의 배수인 원판을 di방향 으로 ki칸 회전. di가 0인 경우는 시계방향, 1인 경우는 반 시계방향
원판에 수가 남아있으면, 인접하면서 수가 같은 것을 모두 찾는다.
- 그러한 경우가 있는 경우 원판에서 인접하면서 같은 수를 모두 지우기
- 없는 경우 : 원판에 적힌 수의 평균을 구하고, 평균보다 큰 수에서 1을 빼고, 작은 수에는 1을 더한다.
원판을 T번 회전시킨 후 원판에 적힌 수의 합을 구하기
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 원판돌리기_17822 {
    static int N, M, T; // 반지름 N, 원판 개수 M, T번 회전
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int xi, di, ki;
    static int result =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            xi = Integer.parseInt(st.nextToken());
            di = Integer.parseInt(st.nextToken());
            ki = Integer.parseInt(st.nextToken());
            rotateBoard(xi, di, ki);
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] != -1){
                    result += board[i][j];
                }
            }
        }
        System.out.println(result);
    }
    static void check(){
        boolean flag = false;
        for(int x=0; x<N; x++){
            for(int y=0; y<M; y++){
                if(board[x][y] != -1 && !visited[x][y]){
                    for(int d=0; d<4; d++){
                        int tx = x + dx[d];
                        int ty = y + dy[d];

                        if(ty < 0){
                            ty = M-1;
                        } else if(ty >= M){
                            ty = 0;
                        }

                        if(0 <= tx && tx < N){
                            if(!visited[tx][ty] && board[tx][ty] == board[x][y]){
                                flag = true;
                                board[x][y] = -1;
                                board[tx][ty] = -1;
                                check();
                            }
                        }
                    }
                }
            }
        }
        if(!flag){
            remove();
        }
    }
    static void rotateBoard(int x, int d, int k){
        for(int i=0; i<N; i++){
            if((i+1)%x != 0) continue;
            if(d==0){ // 시계방향
                for(int j=0; j<k; j++){
                    int[] tmp = board[i].clone();
                    board[i][0] = tmp[M-1];
                    for(int z =1; z<M; z++){
                        board[i][z] = tmp[i-1];
                    }
                }
            } else { // 반시계방향
                for(int j=0; j<k; j++){
                    int[] tmp = board[i].clone();
                    board[i][M-1] = tmp[0];
                    for(int z =0; z<M-1; z++){
                        board[i][z] = tmp[i+1];
                    }
                }
            }
        }
        check();
    }
    static void remove(){
        int sum = 0;
        int cnt = 0;
        float average;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] != -1){
                    sum += board[i][j];
                    cnt++;
                }
            }
        }
        average = (float) sum/cnt;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] != -1){
                    if(board[i][j]<average){
                        board[i][j]+=1;
                    } else if(board[i][j]>average){
                        board[i][j]-=1;
                    }
                }
            }
        }
    }
}
