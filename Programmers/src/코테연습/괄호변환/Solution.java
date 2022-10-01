package 코테연습.괄호변환;

import java.util.Stack;

class Solution {
    static Stack<Character> stack = new Stack<>();
    public String solution(String p) {
        String answer = "";

        // 균형 잡혔는지 검사

        // 1. 입력이 빈 문자열인 경우, 빈 문자열 반환


        // 2. 문자열 w를 균형 잡히도록 u, v로 분리 -> u는 균형 잡힌 문자열로 더이상 분리 불가능
        // v는 빈 문자열일 수 있다.


        // 3. 문자열 u가 올바른 문자열이면, 1부터 다시 수행
        // 문자열이 올바르지 않게 나올 경우 수행 결과를 문자열 u에 이어 붙이고 반환한다.


        // 4. 문자열 u가 올바른 괄호 문자열이 아니면 아래 과정 수행

        return answer;
    }
    // 균형 체크
    public static boolean balanceCheck(String str){
        for(int i=0; i<str.length(); i++){
            if(stack.isEmpty()){
                stack.add(str.charAt(i));
            } else {
                if(stack.peek().equals(str.charAt(i))){
                    stack.add(str.charAt(i));
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String p = "(()())()";
        System.out.println(T.solution(p));
    }
}
