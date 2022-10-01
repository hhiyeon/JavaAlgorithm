package 배열.피보나치수열4;

import java.util.Scanner;

public class Main {
    public static void solution(int num){
        int a=1, b=1, c=0;

        for(int i=2; i<num; i++){
            c=a+b;
            System.out.println(c+" ");
            a =b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        T.solution(n);
    }
}
