package 코테스터디.보석쇼핑;

import java.util.*;

/* 진열된 모든 종류의 보석을 1개씩 포함하는 짧은 구간 구하기
* 중복제거한 후, 보석의 종류를 구한다.
* */
class Solution {
    static HashSet<String> set = new HashSet<>();
    static HashMap<String, Integer> map = new HashMap<>();
    static Queue<String> queue = new LinkedList<>();
    static int length = Integer.MAX_VALUE;
    static int start = 0;
    static int startPoint = 0;
    public static int[] solution(String[] gems) {
        set.addAll(Arrays.asList(gems));

        for(int i=0; i< gems.length; i++){
            if(map.containsKey(gems[i])){
                map.put(gems[i], map.get(gems[i])+1);
            } else {
                map.put(gems[i], 1);
            }
            queue.add(gems[i]);

            while(true){
                String name = queue.peek();
                if(map.get(name)>1){
                    map.put(name, map.get(name)-1);
                    queue.poll();
                    startPoint++;
                } else {
                    break;
                }
            }

            if(set.size() == map.size() && length > queue.size()){
                length = queue.size();
                start = startPoint;
            }
        }

        int[] answer = new int[2];
        answer[0] = start+1;
        answer[1] = start+length;

        return answer;
    }

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer = solution(gems);
        for(int a : answer){
            System.out.println(a);
        }
    }
}
