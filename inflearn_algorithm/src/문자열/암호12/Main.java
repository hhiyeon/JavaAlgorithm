package 문자열.암호12;
/* 암호
# 은 이진수의 1
*은 이진수의 0으로 변환
#*****# -> 1000001 을 10진수화하면 -> 65
65를 아스키번호로 -> 대문자 A
* */

import java.util.Scanner;

public class Main {
    public String solution(int n, String str){
        String answer = "";
        for(int i=0; i<n; i++){
            String tmp = str.substring(0,7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2); // 10진수로 바꿔주기
            answer += (char)num; // 아스키코드 문자로 바꿔주기
            str=str.substring(7); // 그다음꺼로 바꿔주기
        }
        return answer;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }
}
