package 코테연습.스킬트리;

import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0; i<skill_trees.length; i++){
            StringBuilder sb = new StringBuilder();
            String element = skill_trees[i];

            for(int j=0; j<element.length(); j++){ // 선행 스킬 입력
                if(skill.contains(String.valueOf(element.charAt(j)))){
                    sb.append(element.charAt(j));
                }
            }

            for(int z= skill.length(); z>-1;  z--){
                String str = skill.substring(0,z);
                if(str.equals(sb.toString())){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String s = "CBD";
        String[] arr = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(T.solution(s,arr));
    }
}
