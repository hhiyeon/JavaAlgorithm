package 코테스터디.다단계칫솔판매;
/* 조직 내 누가 얼마만큼 이득 가져갔는지
이익에서 10퍼 계산 후 자신을 조직에서 참여시킨 추천인에게 배분하고 나머지는 자신이 가진다.
10퍼를 계산할 때는 원 단위로 절사
10퍼를 계산한 금액이 1원 미만일 때, 이득 분배X

각 판매원 이름을 담은 배열 enroll
각 판매원을 다단계 조직에 참여시킨 다른 판매원의 이름을 담은 배열 referral
판매량 집계 데이터의 판매원 이름을 나열한 배열 seller
판매량 집계 데이터의 판매 수량을 나열한 배열 amount
각 판매원이 득한 이익금을 나열한 배열 return
* */

import java.util.HashMap;

public class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Integer> map = new HashMap<>();
        Node person[] = new Node[enroll.length+1];

        for(int i=0; i<enroll.length+1; i++){
            person[i] = new Node();
        }

        map.put("center", 0);
        int idx = 1;
        for(String name : enroll){
            map.put(name, idx++);
        }

        for(int i=0; i<enroll.length; i++){
            if(referral[i].equals("-")){
                person[map.get(enroll[i])].parent = person[0];
            } else {
                person[map.get(enroll[i])].parent = person[map.get(referral[i])];
            }
        }

        for(int i=0; i< seller.length; i++){
            int value = 100*amount[i];
            int remain = value * 10 / 100;
            if(remain > 0){
                person[map.get(seller[i])].result += (value - remain);
                dfs(person[map.get(seller[i])].parent, remain);
            } else {
                person[map.get(seller[i])].result += value;
            }
        }

        for(int i=0; i<enroll.length; i++){
            answer[i] = person[i+1].result;
        }

        return answer;
    }

    static void dfs(Node current, int value){
        if(current.parent == null){
            return;
        }
        int remain = value * 10 / 100;
        if(remain > 0){
            current.result += value - remain;
            dfs(current.parent, remain);
        } else {
            current.result += value;
        }
    }

    class Node {
        Node parent;
        int result;
        int amount; // 판매 수량
    }
}
