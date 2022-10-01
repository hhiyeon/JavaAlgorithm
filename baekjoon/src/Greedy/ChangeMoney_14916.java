package Greedy;
/* 거스름돈 - 그리디 - 14916 - 실버5 - 2/1(화)
* 2원, 5원
* 거스름돈이 n인 경우 최소 동전의 개수가 몇개인지 알려주는 프로그램
* */

import java.util.Scanner;

public class ChangeMoney_14916 {
    static int n;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 거스름돈

        while(true){
            if(n % 5 == 0){
                System.out.println(count +(n/5));
                break;
            }
            n-=2;
            count++;

            if(n < 0){
                System.out.println(-1);
                break;
            }
        }

    }
}


//
//        if(N == 4 || N == 7){
//            System.out.println(-1);
//        }
//        else if(N % 5 == 0){
//            System.out.println(N/5);
//        }
//        else if(N % 5 == 1 || N % 5 == 3){
//            System.out.println((N/5) + 1);
//        }
//        else if(N % 5 == 2 || N % 5 == 4){
//            System.out.println((N/5) + 2);
//        }
//    }