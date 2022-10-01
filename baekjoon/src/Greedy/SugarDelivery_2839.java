package Greedy;
/* 설탕배달 - 그리디, 자료구조, DP - 브론즈1 - 1/25(화)
* N 킬로그램 배달
* 봉지는 3킬로 or 5킬로
* 최대한 적은 봉지 가져가는 법
*
* 경우의수 3 or 5 or 8(3+5) -> 잘못된 접근..
* 3가지 방법 중 나머지로 떨어지는 애
* */

import java.util.Scanner;

public class SugarDelivery_2839 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 설탕 무게

        if(N == 4 || N == 7){
            System.out.println(-1);
        }
            else if(N % 5 == 0){
                System.out.println(N/5);
            }
            else if(N % 5 == 1 || N % 5 == 3){
                System.out.println((N/5) + 1);
            }
            else if(N % 5 == 2 || N % 5 == 4){
                System.out.println((N/5) + 2);
            }
    }
}
