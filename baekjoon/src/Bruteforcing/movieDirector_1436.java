package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 영화감독 숌 - 브루트포스 - 실버5
* N 번째 영화의 제목에 들어간 숫자를 출력하는 프로그램
* 666 -> 1666 -> 2666 -> 3666 -> 4666
* */
public class movieDirector_1436 {
    static int N;
    static int number = 666;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // N 번째 영화 숫자

        while(true){
            String str = Integer.toString(number); // 계산을 위한 문자열로 바꾸기
                if(str.contains("666")){ // 666 포함하는지 확인
                    count++;

                    if(count == N){ // count 만족하면 반환
                        break;
                    }
                }
            number++;
            }
        System.out.println(number);
    }
}
