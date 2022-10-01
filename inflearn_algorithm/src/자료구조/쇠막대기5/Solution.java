package 자료구조.쇠막대기5;

import java.util.Stack;

// 잘려진 조각의 총 개수를 출력해라.
public class Solution {
    public static int solution(String str){
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='('){
                stack.add('(');
            } else { // ) 인 경우에
                stack.pop();
                if(str.charAt(i-1)=='('){
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String str = "()(((()())(())()))(())";

        System.out.println(T.solution(str));
    }
}
