package Implementation;

import java.util.Scanner;

/* 이항 계수 11050번 - 구현 - 브론즈1
* 자연수 N과 정수 K가 주어졌을 때 이항계수 (N K)를 구하는 프로그램 작성
* 이항계수 공식 (N R) = N! / R!*(N-R)!
* */
public class BinaryCoefficient_11050 {
    static int N, K;
    static int up, down;
    static int BinaryCoefficient;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        up = factorial(N);
        down = factorial(K) * factorial(N-K);

        BinaryCoefficient = up/down;

        System.out.println(BinaryCoefficient);
    }

    public static int factorial(int number){
        if(number == 1) return 1;
        int sum = 1;
        for(int i=1; i<=number; i++){
            sum = sum * i;
        }
        return sum;
    }
}
