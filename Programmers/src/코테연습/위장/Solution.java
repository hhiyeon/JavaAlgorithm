package 코테연습.위장;

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;

        for(int i=0; i<clothes.length; i++){
            String type = clothes[i][1]; // 옷 종류
            map.put(type, map.getOrDefault(type, 1)+1);
            // map.getOrDefault : key가 있으면 해당 value 반환 또는 없으면 default 반환
            //System.out.println(map);
        }

        for(String key : map.keySet()){
            answer *=map.get(key);
            //System.out.println(map.get(key));
        }

        answer--;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[][] c = {{"yellowhat","headgear"},{"bluesunglasses","eyewear"},
                {"green_turban","headgear"}};
        System.out.println(T.solution(c));
    }
}
