package Bruteforcing;
/*큰 수 구성하기 - 브루트포스 - 실버5 - 2/7(월)
N보다 작거나 같은 자연수 중에서 집합 k의 원소로만 구성된 가장 큰 수 출력
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxNumber_18511 {
    static int N, K;
    static int[] number;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        number = new int[K];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<K; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);
        dfs(0);
        System.out.println(answer);

    } public static void dfs(int now){
        if(now > N){
            return;
        }
        if(answer < now){
            answer = now;
        }
        for(int i=K-1; i>=0; i--){
            dfs(now*10+number[i]);
        }
    }
}
