package DP;
/* 포도주 시식 - dp - 실버1 - 2/4(금)
* 규칙
* 1. 잔을 선택하면, 그 잔에 있는 포도주는 모두 마시고 원래 위치에 놓는다.
* 2. 연속으로 놓여있는 3잔을 모두 마실 수 없다.
* 가장 많은 양의 포도주를 마실 수 있는 프로그램 작성
* ex. 6, 10, 13, 9, 8, 1 -> 첫번째, 두번째, 네번째, 다섯번째 = 33
*
* dp[n] = 포도주 n개에서 가장 많이 마실 수 있는 양
* p[n] = n번째 포도주의 양
*
* 1. 0번 연속 마실 수 있는 경우
* dp[n] = dp[n-1]
*
* 2. 1번 연속 마실 수 있는 경우
* dp[n] = dp[n-2] + p[n]
*
* 3. 2번 연속 마실 수 있는 경우
* dp[n] = dp[n-3] + dp[n-1] + p[n]
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GrapeDrink_2156 {
    static int N;
    static int[] cup;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 포도잔의 개수
        cup = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i <=N; i++) { // 포도잔의 양 입력
            cup[i] = Integer.parseInt(br.readLine());
        }

//        * 1. 0번 연속 마실 수 있는 경우
//          * dp[n] = dp[n-1]

//          * 2. 1번 연속 마실 수 있는 경우
//          * dp[n] = dp[n-2] + p[n]

//          * 3. 2번 연속 마실 수 있는 경우
//          * dp[n] = dp[n-3] + p[n-1] + p[n]

        dp[1] = cup[1];
        if(N > 1){
            dp[2] = cup[1] + cup[2];
        }

        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+cup[i], dp[i-3]+cup[i-1]+cup[i]));
        }
        System.out.println(dp[N]);
    }
}
