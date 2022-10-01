package DataStructure;
/* 균형잡힌 세상 - 스택, 문자열 - 실버4 - 1/23(일) & 1/25(화)
* 소괄호, 대괄호
* 짝을 이루는 괄호 안의 문자열이 균형잡혔는지 확인
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalanceWorld_4949 {
    static String str;
    static char word;
    static String result = "yes";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        while(true){
            str = br.readLine();
            if(str.equals(".")){
                break;
            }
            cal(str);
            System.out.println(result);
        }
    }

    public static void cal(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            word = str.charAt(i);

            if (word == '(' || word == '[') {
                stack.push(word);
            }

            else if (word == ')') {
                //System.out.println("test" + stack.peek());
                if (stack.empty() || stack.peek() != '(') {
                    result = "no";
                    stack.push(word);
                } else {
                    stack.pop();
                }
            }

            else if (word == ']') {
                if(stack.empty() || stack.peek() != '['){
                    result = "no";
                    stack.push(word);
                    //System.out.println("test");
                }else {
                    stack.pop();
                }
            }
        }
        if(!stack.empty()){
            result = "no";
        } else {
            result = "yes";
        }
    }
}

