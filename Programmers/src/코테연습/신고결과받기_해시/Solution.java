package 코테연습.신고결과받기_해시;

import java.util.*;
/* 1. 유저는 한 번에 한 명의 유저를 신고할 수 있다.
- 신고 횟수 제한 X
- 한 유저를 여러 번 신고 가능, but 동일한 유저에 대한 신고 횟수는 1회
2. k번 이상 신고된 유저는 게시판 이용 정지 -> 해당 유저를 신고한 모든 유저에게 정지 사실 메일로 발송
- 유저가 신고한 모든 내용을 취합해서 마지막에 한꺼번에 게시판 이용 정지를 시키고 정지 메일 발송
id_list : 이용자 ID
report : 각 이용자가 신고한 이용자의 ID
k : 정지 기준 신고 횟수
각 유저별로 처리 결과 메일을 받은 횟수 return*/
class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<String, HashSet<String>> reportMap = new HashMap<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], 0);
            reportMap.put(id_list[i], new HashSet<>());
        }

        for(int i=0; i<report.length; i++){
            String[] str = report[i].split(" ");
            String key = str[0];
            for(int j=1; j<str.length; j++){
                //map.put(str[i], map.get(str[i])+1);
                reportMap.get(str[j]).add(key);
            }
        }

        for(String key : reportMap.keySet()){
            if(reportMap.get(key).size()>=k){
                for(String reporter : reportMap.get(key)){
                    Integer getMail = map.get(reporter);
                    map.put(reporter, getMail+1);
                }
            }
        }

        answer = new int[id_list.length];

        for(int i=0; i<answer.length; i++){
            answer[i] = map.get(id_list[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(T.solution(id_list, report, k));
    }
}