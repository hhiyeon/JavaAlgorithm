package 코테연습.짝지어제거하기;

import java.util.*;

public class Solution {
    // 알파벳 소문자로 시작
    // 알파벳 2개 붙어있는 애 찾기
    // 둘 제거하고 앞 나머지 문자열 이어 붙이기
    // 반복해서 모두 제거하면 제거하기 완료
    // 성공하면 1, 아닐경우 0
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char element = s.charAt(i);
            if(!stack.isEmpty()&&stack.peek().equals(element)){
                stack.pop();
            } else{
                stack.add(element);
            }
        }

        if(stack.isEmpty()){
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("cdcd"));
    }
}

