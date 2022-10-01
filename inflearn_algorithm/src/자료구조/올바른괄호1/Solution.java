package 자료구조.올바른괄호1;

import java.util.Stack;

// 괄호가 입력되면 올바른 괄호는 YES 아니면 NO 출력
public class Solution {
    public static String solution(String str){
        Stack<Character> stack = new Stack<>();
        String answer = "YES";

        for(int i=0; i<str.length(); i++){
            char element = str.charAt(i);
            if(stack.isEmpty()){
                stack.add(element);
            } else {
                if(!stack.peek().equals(element)){
                    stack.pop();
                } else {
                    stack.add(element);
                }
            }
        }
        if(!stack.isEmpty()){
            answer = "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("(()(()))(()"));
    }
}
