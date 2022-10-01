package Bruteforcing;/*분해합 2231번 - 브론즈2 - 브루트포스
* 자연수 N
* N의 분해합은 N과 N을 이루는 각 자리수의
* 자연수 M 의 분해합이 N 일 때 M을 N의 생성자라고 한다.
* 245의 분해합은 256(=245+2+4+5) -> 245는 256의 생성자
* 가장 작은 생성자를 구하는 프로그램
* */

import java.util.Scanner;

public class subSum_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = 0;

        for (int i = 0; i < N; i++) { // brute force : 1부터 N까지
            int num = i; // 누적합
            int sum = 0;

            while(num !=0) { // 누적합이 0 경우 break
                sum = sum + (num % 10); // 누적합 각 자리수 더하기
                num = num / 10;
            }
            if (N == (sum + i)) { // 각 자리수의 합과 누적합의 값이 자연수일 경우
                result = i; // 누적합
                break;
            }
        }
        System.out.println(result);
    }
}
