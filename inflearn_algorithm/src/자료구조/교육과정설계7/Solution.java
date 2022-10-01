package 자료구조.교육과정설계7;

import java.util.LinkedList;
import java.util.Queue;

// 총 과목 A B  C D E F G
// 필수 과목 CBA 순서대로 들어야 함.
// 수업 설계가 잘되면 YES 아니면 NO
public class Solution {
    public static String solution(String str1, String str2){
        Queue<Character> queue = new LinkedList<>();
        String answer = "YES";

        for(int i=0; i< str1.length(); i++){
            char element = str1.charAt(i);
            queue.add(element);
        }

        for(int i=0; i<str2.length(); i++){
            char element = str2.charAt(i);
            if(queue.contains(element)){
                if(element!= queue.poll()){
                    answer = "NO";
                    break;
                }
            }
            if(!queue.isEmpty()){
                answer = "NO";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String str1 = "CBA";
        String str2 = "CBDAGE";
        System.out.println(T.solution(str1,str2));
    }
}
