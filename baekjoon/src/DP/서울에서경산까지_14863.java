package DP;
/* 서울 -> 경산을 가는길에 모금 활동
* 서울을 제외한 도시의 개수 N
* 구간 1 : 서울 -> 2번째 도시
* 구간 2 : 2번째 도시 -> 3번째 도시
* 구간 N : 마지막 구간
* 구간 사이의 이동 1. 도보 - 모금액
* 2. 자전거 - 모금액
* 정해진 시간 이내로 최대 모금액 찾는 프로그램
* dp[현재 도시][현재까지 걸린 시간] = dp[이전 도시][이전 도시까지 걸린시간]+모금액
* DP[i][j] => i번째 구간에서 j분에 얻을 수 있는 최대 금액
* dp[i][j] 구간 i를 j분 안에 지났을 때 최대로 얻을 수 있는 금액
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서울에서경산까지_14863 {
    static int N, K;
    static int walk, walkMoney, bike, bikeMoney;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[100][100001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            walk = Integer.parseInt(st.nextToken());
            walkMoney = Integer.parseInt(st.nextToken());
            bike = Integer.parseInt(st.nextToken());
            bikeMoney = Integer.parseInt(st.nextToken());
            if (i == 0) {
                dp[0][walk] = walkMoney;
                dp[0][bike] = bikeMoney;
            } else {
                for (int j = 0; j <= K; j++) {
                    if (dp[i - 1][j]==0) {
                        continue;
                    }
                    if (j + walk <= K) {
                        dp[i][j + walk] = Math.max(dp[i][j + walk], dp[i - 1][j] + walkMoney);
                    }
                    if (j + bike <= K) {
                        dp[i][j + bike] = Math.max(dp[i][j + bike], dp[i - 1][j] + bikeMoney);
                    }
                }
            }
        }
        int max = Arrays.stream(dp[N - 1]).max().getAsInt();
        System.out.println(max);
    }
}

