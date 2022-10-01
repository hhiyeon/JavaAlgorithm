package DataStructure;
/* 괄호 - 자료구조 - 스택,문자열 - 실버4 - 1/22(토)
* (와 )으로만 이루어진 문자열
* VPS : 유효한 괄호 문자열
* 그 괄호 안의 문자열들도 VPS가 된다.
* VPS - (())(), ((())) -> YES 출력
* not VPS - (()(, (())())), (() -> NO 출력
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket_9012 {
    static int N;
    static String bracket;
    static char element;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
//        stack = new String[N];

        while (N-- >0) {
            bracket = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean result = false;

            for (int i = 0; i < bracket.length(); i++) {
                element = bracket.charAt(i);

                if (element == '(') {
                    stack.push(element);
                } else if (element == ')') {
                    if (stack.empty()) {
                        result = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!stack.empty() || result) {
                System.out.println("NO");
            } else{
                System.out.println("YES");
            }
        }
    }
}
