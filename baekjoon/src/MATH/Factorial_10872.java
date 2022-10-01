package MATH;

import java.util.Scanner;

public class Factorial_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(factorial(num)!=0){
            System.out.println(factorial(num));
        } else {
            System.out.println(1);
        }
    }
    public static int factorial(int n){
        if (n<=1) {
            return n;
        }
        return factorial(n-1)*n;
    }
}
