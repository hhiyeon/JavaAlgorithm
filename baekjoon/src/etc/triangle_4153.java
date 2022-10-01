package etc;/*직각 삼각형 4153번 - 브론즈3
* 각 변들이 길이가 3,4,5 일 경우 직각 삼각형
* 주어진 세변이 삼각형이 직각인지 구분하기
* 직각 삼각형 = a^2 + b^2 = c^2
* */

import java.util.Scanner;

public class triangle_4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();
            int input3 = sc.nextInt();

            if(input1 == 0 && input2 == 0 && input3 ==0){
                break;
            }

            int condition1 = (input1*input1) + (input2*input2);
            int max1 = input3*input3;

            int condition2 = (input2*input2) + (input3*input3);
            int max2 = input1*input1;

            int condition3 = (input1*input1) + (input3*input3);
            int max3 = input2*input2;

            if(condition1 == max1){
                System.out.println("right");
            } else if(condition2 == max2){
                System.out.println("right");
            } else if(condition3 == max3) {
                System.out.println("right");
            }
            else{
                System.out.println("wrong");
            }
        }

    }
}
