package 문자열.유효한팰린드롬8;
/* 앞 뒤가 같은 문자열 = 팰린드롬
* 알파벳 이외의 문자들은 무시하기
* 대소문자 구분하지 않기*/

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer="NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        // replaceAll -> 대문자 A-Z 아닌 애들은 "" 으로 바꿔라
//        System.out.println(str);
        String tmp = new StringBuffer(str).reverse().toString();
        if(str.equals(tmp)){
            answer = "YES";
        }
        return answer;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
