package 문자열.회문문자열7;

import java.util.Scanner;

/* 앞뒤가 같은 문자열 = 회문 문자열
* 대소문자 구분하지 않고,
* 같으면 YES 다르면 NO 출력
* */
public class Main {
    public String solution(String str){
        String answer = "YES";
        int len = str.length();
        str = str.toUpperCase(); // 대문자로 바꿔버림

        for(int i=0; i<len/2; i++){
            if(str.charAt(i)!=str.charAt(len-i-1)){
                answer = "NO";
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
