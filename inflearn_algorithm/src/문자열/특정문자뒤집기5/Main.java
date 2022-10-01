package 문자열.특정문자뒤집기5;
/* 알파벳과 특수문자로 구성된 문자열이 들어오면
알파벳만 뒤집고 특수문자는 자기 자리 그대로 있는 문자열 출력 */

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer;
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length()-1;

        while(lt<rt){
            if(!Character.isAlphabetic(s[lt])){ // lt가 알파벳이 아닐 경우 = 특수문자
                lt++;
            } else if(!Character.isAlphabetic(s[rt])){ // rt가 특수문자
                rt--;
            } else { // 둘다 알파벳인 경우
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s); // 문자 배열을 string으로 바꿔줌
        return answer;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
