package 투포인터_슬라이딩윈도우.공통원소구하기2;

// 공통 원소 추출해서 오름차순
// 배열들은 오름차순으로 미리 정렬해두어야 한다.
// 1 2 3 5 9
// 2 3 5 7 8
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static ArrayList<Integer> solution(int[] arr1, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1=0;
        int p2=0;
        int n = arr1.length;
        int m = arr2.length;

        while(p1<n && p2<m){
            if(arr1[p1]==arr2[p2]){ // 둘중에 값 아무거나 넣고, 둘다 idx증가
                answer.add(arr1[p1++]);
                p2++;
            } else if(arr1[p1]>arr2[p2]){ // 1번째 배열이 더 큰 경우 -> 작은 쪽을 증가 시키기
                p2++;
            } else {
                p1++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr1 = {1,3,9,5,2};
        int[] arr2 = {3,2,5,7,8};
        System.out.println(T.solution(arr1,arr2));
    }
}
