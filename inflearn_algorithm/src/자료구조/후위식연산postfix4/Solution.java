package 자료구조.후위식연산postfix4;

import sun.tools.jstack.JStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static int solution(String str){
        Stack<Integer> s = new Stack<>();
        int answer = 0;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){ // 숫자일 경우
                s.add(ch-48);
            } else { // 숫자가 아닐 경우
                int rt = s.pop();
                int lt = s.pop();

                if(ch == '+'){
                    s.add(lt+rt);
                } else if(ch == '-'){
                    s.add(lt-rt);
                } else if(ch == '/'){
                    s.add(lt/rt);
                } else if(ch == '*'){
                    s.add(lt*rt);
                }
            }
        }

        answer = s.get(0); // 맨 앞의 결과가 연산의 결과가 된다.
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String str = "352+*9-";
        System.out.println(T.solution(str));
    }
}
