package 문자열.문자열압축11;
/* 문자열이 주어질 때 압축된 문자열 출력
KKHSSSSSSSE -> K2HS7E
* */

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer="";
        str = str+ " "; // 뒤에 공백 하나 넣어주기
        int cnt = 1;
        for(int i=0; i< str.length()-1; i++){
            if(str.charAt(i)==str.charAt(i+1)){ // 앞뒤가 같으면 cnt +1
                cnt++;
            }else { // 다를 경우
                answer+=str.charAt(i); // 앞의 문자열 출력
                if (cnt>1) { // 여기서 cnt가 1보다 클 경우
                    answer += String.valueOf(cnt); // cnt를 string으로 만들고 answer에 추가
                    cnt =1; // cnt 초기화
                }
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
