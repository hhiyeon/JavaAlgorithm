package etc;

import java.util.Scanner;

/* 숫자 뒤집기

ex) 4357
7534 = (7*1000) + (5*100) + (3*10) + (4*1)

숫자를 10으로 나눈 나머지를 계속 더해준다.
덧셈을 할 때 기존 숫자에 곱하기 10을 해줘야 자릿수 넘기기 가능

* */
public class const_2908 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();

        int reverseA =0;
        int reverseB = 0;

        while(A!=0){
            reverseA = reverseA * 10 + A % 10;
            A /= 10;
        }
        while(B!=0){
            reverseB = reverseB * 10 + B % 10;
            B /= 10;
        }

        if(reverseA > reverseB){
            System.out.println(reverseA);
        } else{
            System.out.println(reverseB);
        }
    }
}
