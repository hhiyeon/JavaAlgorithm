package 문자열.중복문자제거6;

import java.util.Scanner;

/* 소문자로 된 한개의 문자열이 입력될 때
중복된 문자를 제거 후 출력
순서는 유지*/
public class Main {
    public String solution(String str){
        String answer = "";

        for(int i=0; i<str.length(); i++){
            //System.out.println(str.charAt(i)+" "+i+" "+str.indexOf(str.charAt(i)));
            if(str.indexOf(str.charAt(i))==i){
                // indexOf : 특정 문자가 앞에서 처음 발견되는 인덱스를 반환
                // lastIndexOf : 뒤에서 부터 처음 발견되는 인덱스를 반환
                answer+=str.charAt(i); // 문자가 중복되지 않는 경우에만 string 에 추가
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
