package 문자열.문자찾기1;

import java.util.Scanner;

public class Main {
    public int solution(String str, char t){
        int answer =0;
        str = str.toUpperCase(); // 대문자 변환
        t = Character.toUpperCase(t); // 대문자 변환

        for(char x : str.toCharArray()){
            if(x==t){ // 입력받아서 대문자로 만든 t와
                // 대문자 str을 char형 배열로 만들어 원소가 x 인 값들을
                // 비교 후 같으면 증가시킨다.
                answer ++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(T.solution(str, c));
    }
}
