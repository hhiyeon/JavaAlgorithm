package 코테스터디.프렌즈4블록;
import java.util.*;
import java.io.*;
/* 2 X 2 형태의 블록이 4개가 붙어있을 경우 사라지면서 점수 획득
같은 블록이 겹칠경우도 존재
블록이 지워진 후에 위에 있는 블록이 아래로 떨어진다.
빈 공간을 채운 후 또 4개의 블록이 모이면 다시 지워지고 떨어지고 반복
지워지는 블록의 개수 모두 구하기
1. 블록 체크
    1.1. 블록 지운다. -> 빈공간을 채운다. -> 블록 체크
    1.2. 블록을 안지운다.
* */

class Solution {
    static int M, N;
    static char[][] map;
    static int[][] check;
    static int count = 0;
    static boolean flag = true;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n;

        map = new char[m][n];
        check = new int[m][n];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }

        while(flag){
            flag = false;
            checkBlock();
            dropBlock();
        }
        answer = count;
        return answer;
    }
    public static void checkBlock(){
        for(int i=0; i<M-1; i++){
            for(int j=0; j<N-1; j++){
                if(map[i][j]!='0'){
                    char idx = map[i][j];
                    if(map[i][j+1] == idx && map[i+1][j] == idx && map[i+1][j+1] == idx){
                        check[i][j] = 1;
                        check[i+1][j] = 1;
                        check[i][j+1] = 1;
                        check[i+1][j+1] = 1;
                        flag = true;
                    }
                }
            }
        }
    }

    public static void dropBlock(){
        for (int i = 0; i < M; i++) {
            for (int j = 0; j< N; j++) {
                if (check[i][j]==1) {
                    count++;
                }
                for(int z = j; z>=0; z--){
                    if(z==0){
                        map[z][i] = '0';
                    } else {
                        map[z][i] = map[z-1][i];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC",
                "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(T.solution(m,n,board));
    }
}
