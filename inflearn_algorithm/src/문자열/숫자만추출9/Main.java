package 문자열.숫자만추출9;
/* 문자와 숫자가 섞여있는 문자열에서 숫자만 추출하고
* 순서대로 자연수 만들기 -> 0, 1, 2, 0, 5 -> 1205
* */

import java.util.Scanner;

public class Main {
    public int solution(String str){
//        int answer = 0;
        String answer = "";

        for(char x : str.toCharArray()){
//            if(x>=48 && x<=57){ // 알파벳인 경우
//                answer = answer * 10 + (x - 48);
//            }
            if(Character.isDigit(x)){ // 숫자인 경우
                answer += x; // 숫자만 추가
            }
        }

        return Integer.parseInt(answer);
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
