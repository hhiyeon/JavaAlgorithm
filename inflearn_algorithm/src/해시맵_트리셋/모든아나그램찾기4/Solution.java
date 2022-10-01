package 해시맵_트리셋.모든아나그램찾기4;
// S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열 개수 구하기
// 대소문자 구분
// 아나그램 abc = bac = cba

import java.util.HashMap;

public class Solution {
    public static int solution(String s, String t){
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for(char x : t.toCharArray()) bm.put(x, bm.getOrDefault(x,0)+1);
        int L = t.length()-1;
        for(int i=0; i<L; i++) am.put(s.charAt(i), am.getOrDefault(s.charAt(i), 0)+1);
        int lt = 0;
        for(int rt=L; rt<s.length(); rt++){
            am.put(s.charAt(rt), am.getOrDefault(s.charAt(rt), 0)+1);
            if(am.equals(bm)) answer++;
            am.put(s.charAt(lt), am.get(s.charAt(lt))-1);
            if(am.get(s.charAt(lt))==0) am.remove(s.charAt(lt));
            lt++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String s = "bacaAacbaa";
        String t = "abca";
        System.out.println(T.solution(s,t));
    }
}