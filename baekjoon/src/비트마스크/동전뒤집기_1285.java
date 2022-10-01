package 비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*동전 뒤집기 - 비트마스크, 그리디, 완전탐색 - 골드1 - 3/1
* N^2개의 동전이 N행 N열 이루어져 있음
* 앞면 H, 뒷면 T
* 작업 : 한 열에 높인 N개 모두 뒤집기
* 뒷면이 위를 향하도록 놓인 동전의 개수가 2개보다 작을 수 없다. T >=2
* 뒷면이 위를 향하는 동전 개수를 최소로 할 때, 최소 개수 구하는 프로그램
* */
public class 동전뒤집기_1285 {
    static int N;
    static char[][] coin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        coin = new char[N][N];

        for(int i=0; i<N; i++){
            String arr = br.readLine();
            for(int j=0; j< N; j++){
                coin[i][j] = arr.charAt(j);
            }
        }

        int answer = N*N;

        for(int bit = 0; bit<(1<<N); bit++){
            int sum = 0;
            for(int i=0; i<N; i++){
                int TCnt = 0;
                for(int j=0; j<N; j++){
                    char cur = coin[j][i];
                    if((bit&(1<<j))!=0){
                        cur = reverseCoin(cur);
                    }
                    if(cur=='T'){
                        TCnt++;
                    }
                }
                sum+=Math.min(TCnt, N-TCnt);
            }
            if(sum < answer){
                answer = sum;
            }
        }
        System.out.println(answer);
    }
    public static char reverseCoin(char state){
        if(state=='T'){
            return 'H';
        } else {
            return 'T';
        }
    }
}
