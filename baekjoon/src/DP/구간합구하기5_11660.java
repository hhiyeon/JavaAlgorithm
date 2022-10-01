package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*구간합구하기5 - dp, 누적합 - 실버1 - 3/10(목)
* N x N 표
* (x1, y1) 부터 (x2, y2)까지 합을 구하는 프로그램 작성하기
* */
public class 구간합구하기5_11660 {
    static int N, M; // 표의 크기, 합을 구해야하는 횟수
    static int map[][], dp[][];
    static int x1,y1,x2,y2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            sb.append(sumSection(x1,y1,x2,y2)).append('\n');
        }
        System.out.println(sb);
    }
    public static int sumSection(int x1, int y1, int x2, int y2){
        return dp[x2][y2]-dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
    }
}
