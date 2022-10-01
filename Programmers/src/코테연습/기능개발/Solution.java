package 코테연습.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 각 배포마다 몇개 기능이 배포되는지 출력
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = {};

        for(int i=0; i<progresses.length; i++){
            //System.out.println(progresses[i]);
            int needDay = ((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
            q.add(needDay); // 시간대를 queue에 저장
        }

        int start = q.poll(); // 맨 앞의 큐를 꺼내준다.
        int count = 1;
        while(true){
            if(start<q.peek()){ // 그 다음 큐보다 일수가 높을 경우
                //System.out.println(count);
                list.add(count); // 카운트를 리스트에 넣어준다.
                count=1; // 초기화
                start = q.poll(); // 초기화
            } else {
                count++; // 일수가 높지 않을 경우 카운트를 높여준다.
                q.poll();
            }
            if(q.isEmpty()){
                break;
            }
        }
        list.add(count);

        answer = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] p = {93,30,55};
        int[] s = {1,30,5};
        System.out.println(T.solution(p,s));
    }
}