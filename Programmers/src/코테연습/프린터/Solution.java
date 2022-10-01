package 코테연습.프린터;

import java.util.*;

// 인쇄 대기 목록 맨 앞 J 가져오기
// 나머지 인쇄 목록이 더 중요도 높으면 J는 맨 뒤로
// 아니면 J 출력
// 내가 인쇄를 요청한 문서의 0~n-1 인쇄 순서 출력하기
class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int solution(int[] priorities, int location) {
        int answer = 0;

        for(int i=0; i<priorities.length; i++){
            pq.add(priorities[i]);
        }

        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i]==pq.peek()){
                    //System.out.println(pq.peek());
                    if(i==location){
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] p = {1,1,9,1,1,1};
        int l = 0;
        System.out.println(T.solution(p,l));
    }
}
