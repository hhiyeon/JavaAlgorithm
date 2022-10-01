package MATH;

import java.util.Scanner;

/* 최대 공약수와 최대공배수 2609번 - 실버5
두 개의 자연수 입력 후 최대 공약수와 최대 공배수 출력
최대 공약수 = GCD(a,b) -> 계속 구하다가 b가 0 일경우 a가 최대 공약수
최대 공배수 = 두 자연수의 곱 / 최대공약수
* */
public class GCD_LCM_2609 {
    static int num1, num2;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        num1 = sc.nextInt();
        num2 = sc.nextInt();

        int gcd = GCD(num1, num2);
        int lcm = (num1*num2)/gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
