package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 숫자 야구 - 2503 - 브루트포스 - 실버4 - 2/7(월)
 * 같은 자리면 1 스트라이크
 * 다른 다리에 같은 숫자가 있으면 1볼
 * 여러 값을 받고 몇개의 숫자가 가능한지 맞추기
 */
public class 미풀이_NumberBaseBall_2503 {
    static int N;
    static int[] number;
    static int[] strike;
    static int[] ball;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 질문 개수 입력
        number = new int[N];
        strike = new int[N];
        ball = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            number[i] = Integer.parseInt(st.nextToken());
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
            System.out.println(number[i]+" "+ strike[i]+" "+ball[i]);
        }
    }
}
