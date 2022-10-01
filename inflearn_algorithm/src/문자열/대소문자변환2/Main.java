package 문자열.대소문자변환2;

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer = "";

        for(char x : str.toCharArray()){ // string을 기반으로 문자배열 생성
//            if(Character.isLowerCase(x)){ // 소문자인지 물어보는 라이브러리가 있음
//                answer+=Character.toUpperCase(x); // x가 대문자가 된다.
//            } else {
//                answer+=Character.toLowerCase(x); // x가 소문자가 된다.
//            }
            if(x>=65 && x<=90){ // 65~90 대문자인 경우
                answer+=(char)(x+32);
            } else if(x>=97 && x<=122){ // 97~122 소문자인 경우
                answer+=(char)(x-32);
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
