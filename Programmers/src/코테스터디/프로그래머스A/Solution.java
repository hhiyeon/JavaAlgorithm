package 코테스터디.프로그래머스A;
/* (), [], {}
* A가 올바른 문자열이면 : (A), [A], {A}도 올바른 괄호 문자열
* -> []가 올바른 괄호 문자열이기 때문에, ([])도 올바른 괄호 문자열
*
* A,B가 올바른 문자열이면, AB도 올바른 괄호 문자열
* -> {}, ([])가 올바른 괄호 문자열이기 때문에, {}([])도 올바른 괄호 문자열
*
* 올바른 괄호 문자열에서 딱 하나의 문자가 제거된 문자열이 있으면
* 이 문자열에 제거된 문자를 다시 삽입함으로써 다시 올바른 괄호 문자열을 만들고자 한다.
* 이때 문자열이 삽입될 수 있는 위치가 여러개일 수 있다.
* 문자열에서 딱 하나의 문자가 제거된 문자열 s가 매개변수로 주어질 때
* s에 제거된 문자 하나를 삽입해서 s를 올바른 괄호 문자열로 만들 수 있는 위치의 개수를 구해라
* */

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static char findStr;
    static char insertStr;
    public int solution(String s){
        int answer = 0;

        for(int i=0; i<s.length(); i++){
            StringBuffer sb = new StringBuffer();

            sb.append(s);
            sb.insert(i, insertStr);

            if(checkStr(sb.toString())){
                answer++;
            }
        }

        System.out.println(findStr);
        return answer;
    }

    static boolean checkStr(String s){ // 올바른 문자열인지 체크
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            try {
                switch (s.charAt(i)){
                    case '[':
                        stack.add('[');
                        break;
                    case ']':
                        if(stack.peek() != '['){
                            return false;
                        }
                        stack.pop();
                        break;
                    case '{':
                        stack.add('{');
                        break;
                    case '}':
                        if(stack.peek() != '{'){
                            return false;
                        }
                        stack.pop();
                        break;
                    case '(':
                        stack.add('(');
                        break;
                    case ')':
                        if(stack.peek() != '('){
                            return false;
                        }
                        stack.pop();
                        break;
                }
            } catch (Exception e){
                return false;
            }
        }

        if(stack.size()>=1) { // stack 이 비지 않을 경우
            if(stack.size()>1){
                stack.pop(); // 맨 위의 값 제거
            }
            findStr = stack.pop();
            switch (findStr) {
                case '[':
                    insertStr = ']';
                    break;
                case ']':
                    insertStr = '[';
                    break;
                case '(':
                    insertStr = ')';
                    break;
                case ')':
                    insertStr = '(';
                    break;
                case '{':
                    insertStr = '}';
                    break;
                case '}':
                    insertStr = '{';
                    break;
            }
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(T.solution(s));
    }
}

