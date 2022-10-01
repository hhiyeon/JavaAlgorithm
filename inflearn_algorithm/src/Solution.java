import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

// 대문자로 된 문자열 컴퓨터로 매일 보냄
// 한문자에 # 또는 *이 일곱개 있다.
// 1. 일곱자리의 이진수로 바꾼다. -> # 1, *은 0
// 2. 바뀐 2진수를 10진수화 한다. -> 1000001 -> 65
// 3. 아스키 번호가 65문자로 변환 -> 'A'

public class Solution {
    public String solution(String s){
        String answer = "";

        for(int i=0; i<4; i++) {
            String temp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            // 문자를 잘라주고, 1. 이진수로 바꿔준다.

            int num = Integer.parseInt(temp, 2);
            // 2진수->10진수

            answer += (char) num;
            // 아스키코드 변환 int형을 char으로 강제변환

            s = s.substring(7);
            // 앞에 문자 자르기

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("#****###**#####**#####**##**"));
    }
}
