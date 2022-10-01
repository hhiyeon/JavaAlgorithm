package MATH;
/* 달팽이는 올라가고 싶다 - 수학 - 브론즈1 - 1/23(일)
* 정상 높이 V
* 낮에 A미터 가능
* 밤에 B미터 미끄러짐
* 며칠 걸리는지?
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Snail_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 목표 높이
        int B = Integer.parseInt(st.nextToken()); // 낮에 올라가는 높이
        int V = Integer.parseInt(st.nextToken()); // 밤에 미끄러지는 높이

        int day = (V-B)/(A-B);

        // 잔여 높이가 남은 경우
        if((V-B)%(A-B) !=0){
            day++;
        }

        System.out.println(day);
    }
}
