package 문자열.문장속단어3;
/*문장 속 가장 긴 단어 출력
* 같은 길이가 있을 경우 앞쪽에 위치한 단어가 답*/

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String anwser=""; // 가장 긴 단어를 저장하기 위한 문자열
        int m = Integer.MIN_VALUE; // 가장 작은 수로 초기화
        String[] s = str.split(" ");
        for(String x : s){
            //System.out.println(x);
            int len = x.length();
            if(len>m){
                m=len;
                anwser=x;
            }
        }
        return anwser;
    }
    public static void main(String[] args){
        Main T = new Main(); // 객체 생성
        Scanner sc = new Scanner(System.in); // 입력받기 위한 함수
        String str = sc.nextLine(); // 한 문장 입력받기
        System.out.println(T.solution(str)); // 문장을 solution 함수에 입력
    }
}
