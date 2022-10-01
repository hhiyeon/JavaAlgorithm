package 이분탐색;
/* 가장 끝의 0의 개수가 M개인 N! 중에서 가장 작은 N을 찾는 프로그램 작
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼0의개수_11687 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int N = 0;
        while(true){
            N = N + 5;
            int zeroCnt = calculation(N);

            if(M == zeroCnt){
                System.out.println(N);
                break;
            } else if(M < zeroCnt){
                System.out.println(-1);
                break;
            }
        }
    }
    static int calculation(int num){
        int count = 0;
        while(num > 0){
            System.out.println("num" + num);
            count += num / 5;
            System.out.println("count" + count);
            num/=5;
            System.out.println("num" + num);
        }
        return count;
    }
}

