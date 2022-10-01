package 해시맵_트리셋.학급회장1;

import java.util.HashMap;

// A B C D E 후보가 등록
public class Solution {
    public static String solution(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        String answer = "";
        int max = Integer.MIN_VALUE;

        for(int i=0; i<str.length(); i++){
            char element = str.charAt(i);
            map.put(element, map.getOrDefault(element,0)+1);
            // map.get으로 넣으면 오류나기 때문에 getOrDefault 사용
        }

        // map.keySet으로 값을 전부 가져와서 key를 인덱스로 사용
        for(char key : map.keySet()){
            if(map.get(key)>max){ // count가 더 큰 경우
                max = map.get(key); // max 값을 갱신해주고
                answer += key; // key 값을 갱신해준다.
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("BACBACCACCBDEDE"));
    }
}
