package DP;
/* 파일 합치기 - dp - 골드3 - 2/17(목)
* 소설은 여러 chapter로 나누어 쓴다.
* 각 chap은 각각 다른 파일에 저장
* 모든 chap을 쓴 후, 각 chap의 파일을 합쳐서 한개의 파일을 만든다.
* 이 과정에서 두 개의 파일을 합쳐서 임시 파일 만들고
* 이 임시 파일이나 원래의 파일을 계속 두 개씩 합쳐서 소설의 여러 chap 들이 연속이 되도록 파일을 합친다.
* 최종적으로 하나의 파일로 합친다.
* 두 개의 파일을 합칠 때 필요한 비용(시간)이 두 파일 크기의 합일 때
* 최종적으로 한 개의 파일을 완성할 때 필요한 비용의 총합 계산
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileCombine_11066 {
    static int T; // 테스트 데이터 개수
    static int K; // 소설을 구성하는 장의 수
    static int[] files;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for(int t=0; t<T; t++){
            K = sc.nextInt();
            sum = new int[K+1];
            files = new int[K+1];
            dp = new int[502][502];

            for(int i=1; i<=K; i++){
                files[i] = sc.nextInt();
                sum[i] = sum[i-1] + files[i];
            }

            solution();
            System.out.println(dp[1][K]);
        }
    }
    public static void solution(){
        for(int i=2; i<=K; i++){
            for(int j=i-1; j>0; j--){
                dp[j][i] = 999999999;
                for(int z=j; z<=i; z++){
                    dp[j][i] = Math.min(dp[j][i], dp[j][z] + dp[z+1][i]);
                }
                dp[j][i] += sum[i] - sum[j-1];
            }
        }
    }
}
