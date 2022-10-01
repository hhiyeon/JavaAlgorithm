package 해시맵_트리셋.매출액의종류3;

import java.util.ArrayList;
import java.util.HashMap;

// N일동안의 매출기록에서 K일 동안의 매출액의 종류를 각 구간별로 구하라
public class Solution {
    public static ArrayList<Integer> solution(int[] arr){
        int n = 7;
        int k = 4;
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();

        for(int i=0; i<k-1; i++){
            HM.put(arr[i], HM.getOrDefault(arr[i],0)+1);
        }
        int lt = 0;
        for(int rt=k-1; rt<n; rt++){
            HM.put(arr[rt], HM.getOrDefault(arr[rt],0)+1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt])-1);
            if(HM.get(arr[lt])==0) {
                HM.remove(arr[lt]);
            }
            lt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {20,12,20,10,23,17,10};
        System.out.println(T.solution(arr));
    }
}
