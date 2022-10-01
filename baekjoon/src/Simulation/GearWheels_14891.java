package Simulation;
/*톱니바퀴 - 시뮬레이션 - 실버 1 - 1/31(일)
* 8개의 톱니를 가지고 있는 톱니바퀴 4개
* 톱니 N극 또는 S극
* 가장 왼쪽 1번 그 다음 오른쪽 2번 -> 3 -> 가장 오른쪽 4번
* 톱니바퀴 K번 회전
* 맞닿은 톱니바퀴가 서로 극이 다르면, B는 A가 회전한 방향의 반대
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GearWheels_14891 {
    static int[][] arr = new int[4][8];
    static int K; // 회전 횟수
    static String str;
    static int num, dir;
    static int score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<4; i++){
            str = br.readLine();
            for(int j=0; j<8; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine()); // 회전 횟수

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());

            solution(num-1, dir);
        }

        for(int i=0; i<4; i++){
            score += arr[i][0]*(1<<i);
        }
        System.out.println(score);
    }

    static void solution(int num, int dir){
        left(num-1, -dir);
        right(num+1, -dir);
        rotate(num, dir);
    }
    static void left(int num, int dir){
        if(num < 0){
            return;
        } else if(arr[num][2] != arr[num+1][6]){
            left(num-1, -dir);
            rotate(num, dir);
        }
    }
    static void right(int num, int dir){
        if(num > 3){
            return;
        } else if(arr[num][6] != arr[num-1][2]){
            right(num+1, -dir);
            rotate(num, dir);
        }
    }
    static void rotate(int num, int dir){
        if(dir == 1){ // 시계 방향
            int temp = arr[num][7];
            for(int i=7; i>0; i--){
                arr[num][i]=arr[num][i-1];
            }
            arr[num][0] = temp;
        } else {
            int temp = arr[num][0];
            for(int i=0; i<7; i++){
                arr[num][i]=arr[num][i+1];
            }
            arr[num][7] = temp;
        }
    }
}
