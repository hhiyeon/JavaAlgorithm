package 해시맵_트리셋.K번째큰수5;

import java.util.Collections;
import java.util.TreeSet;

// 카드 N개 1~100사이
// 3장 뽑아서 합한 값 기록 -> 3장 뽑을 수 있는 모든 경우 기록
// 기록한 값 중에 K번째 큰 수 구하기
// 중복을 제거하고 순서유지하고 정렬을 하면 좋아보임 -> treeset 사용
public class Solution {
    public static int solution(int[] arr, int K){
        // 그냥 하면 오름차순으로 정렬되기 때문에 Collections.reverseOrder으로 내림차순 만들기
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        int answer = 0;

        // 카드 3장 뽑기
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int z=j+1; z<arr.length; z++){
                    Tset.add(arr[i]+arr[j]+arr[z]);
                }
            }
        }

        int cnt = 0;
        for (int x: Tset) {
            cnt++;
            if(cnt==3){
                answer = x;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {13,15,34,23,45,65,33,11,26,42};
        int K = 3;
        System.out.println(T.solution(arr, K));
    }
}
