package Bruteforcing;
/* 체스판 다시 칠하기 1018번 - 브루트포스 - 실버 5
* MN 개의 단위 정사각형 M x N 크기
* 검정 or 흰색으로 칠해져 있다.
* 보드를 잘라서 8x8 크기로 만들것
* 체스판은 흰색 검은색 번갈아서 칠해져있어야 한다.
* 1. 맨 왼쪽 위 칸이 흰색인 경우
* 2. 맨 왼쪽 위 칸이 검은색인 경우
* */
import java.util.Scanner;

public class ChessFill_1018 {
    static int N, M;
    static boolean [][] board;
    static String color;
    static int min = 64;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 체스판 가로
        M = sc.nextInt(); // 체스판 세로

        board = new boolean[N][M];

        for(int i=0; i<N; i++) {
            color = sc.next();
            for (int j = 0; j < M; j++) {
                if (color.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }
        for(int i=0; i< N-7; i++){
            for(int j=0; j<M-7; j++){
                find(i,j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y){
        int end_x = x+8;
        int end_y = y+8;
        int count = 0;

        boolean TF = board[x][y];

        for(int i=x; i<end_x; i++){
            for(int j=y; j<end_y; j++){
                if(board[i][j] != TF){
                    count ++;
                }
                TF = (!TF);
            }
            TF = !TF;
        }
        count = Math.min(count, 64-count);
        min = Math.min(min, count);
    }
}

