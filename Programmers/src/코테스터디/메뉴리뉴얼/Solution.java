package 코테스터디.메뉴리뉴얼;
/* 단품메뉴를 조합해서 코스요리 구성
가장 많이 함께 주문한 단품메뉴로 코스요리메뉴 구성
코스요리 메뉴는 최소 2가지 이상, 최소 2명 이상의 손님이 주문한 단품메뉴 조합만 인정
order 단품메뉴
course 코스요리 구성하는 단품메뉴들의 개수
* */
import java.util.*;

public class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static List<String> result = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        // 모든 조합 찾기
        for(int i=0; i<course.length; i++) {
            map = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                dfs(orders[j], 0, 0, course[i], "");
            }
            // 최대 주문 조합 찾기
            int max = 0;
            for (String key : map.keySet()) {
                max = Math.max(max, map.get(key));
            }
            // 메뉴는 최소 2가지 이상, 최소 2명 이상의 손님이 주문한 단품메뉴 조합만 인정
            for (String key : map.keySet()) {
                if (map.get(key) >= 2) {
                    if (max == map.get(key)) {
                        result.add(key);
                    }
                }
            }
        }
        Collections.sort(result);
        answer = new String[result.size()];

        return result.toArray(answer);
    }

    static Map<String, Integer> dfs(String order, int index, int size, int courseSize, String str){
        if(size == courseSize){
            char[] menu = str.toCharArray();
            Arrays.sort(menu);
            str = String.valueOf(menu);
            map.put(str, map.getOrDefault(str, 0)+1); // 조합별 count
        } else {
            for(int i=index; i<order.length(); i++){
                dfs(order, i+1, size+1, courseSize, str+order.charAt(i));
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        System.out.println(Arrays.toString(T.solution(orders, course)));
    }
}
