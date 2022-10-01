package 해시맵_트리셋.아나그램2;

import java.util.HashMap;

// 아나그램 : 두 문자열의 알파벳의 나열 순서는 다르지만, 알파벳 개수는 일치할 경우
public class Solution {
    public static String solution(String str1, String str2){
        HashMap<Character, Integer> map = new HashMap<>();
        String answer = "YES";

        for(char x : str1.toCharArray()){
            // map에 알파벳 개수 넣기
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for(char x : str2.toCharArray()){
            // 첫번째 문자열에 두번째 문자열에 해당하는 값이 존재하지 않으면
            if(!map.containsKey(x) || map.get(x)==0){
                return "NO"; // NO 출력
            }
            map.put(x, map.get(x)-1);
            // 값이 존재하면 map의 value를 줄여준다.
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        //System.out.println(T.solution("AbaAeCe", "baeeACA"));
        System.out.println(T.solution("abaCC", "Caaab"));
    }
}
