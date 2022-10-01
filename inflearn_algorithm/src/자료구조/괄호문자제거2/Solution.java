package 자료구조.괄호문자제거2;

import java.util.Stack;

public class Solution {
    public static String solution(String str){
        Stack<Character> stack = new Stack<>();
        String answer = "";

        for(int i=0; i<str.length(); i++){
            char element = str.charAt(i);

            if(stack.isEmpty()){
               stack.add(element);
            } else {
                if(element==')') {
                    while (stack.pop() != '(');
                } else {
                    stack.add(element);
                }
            }
        }

        for(int i=0; i<stack.size(); i++){
            answer += stack.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
    }
}
