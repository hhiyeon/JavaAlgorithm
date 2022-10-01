package 문자열.가장짧은문자거리10;
/* 한 개의 문자열 s와 문자 t가 주어질 때
문자열 s의 각 문자가 문자 t와 떨어진 최소거리 출력
teachermode e -> 10121012210
* */

import java.util.Scanner;

public class Main {
    public int[] solution(String str, char c){
        int[] answer = new int[str.length()];
        int p =1000;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==c){
                p=0;
                answer[i]=p;
            } else {
                p++;
                answer[i]=p;
            }
        }
        p=1000;
        for(int i = str.length()-1; i>=0; i--){
            if(str.charAt(i)==c){
                p=0;
            } else {
                p++;
                answer[i]=Math.min(answer[i], p); // 앞에서 넣은 값과 비교해서 작은 값을 넣기
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for(int x : T.solution(str, c)){
            System.out.println(x+" ");
        }
    }
}
