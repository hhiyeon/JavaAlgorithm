package 투포인터_슬라이딩윈도우.두배열합치기1;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> solution(int[] arr1, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0;
        int p2=0;
        int n = arr1.length;
        int m = arr2.length;

        while(p1<n && p2<m){ // 배열1 또는 배열2가 탐색이 끝날때까지 반복
            if(arr1[p1]<arr2[p2]){ // 배열2가 더 큰 경우
                answer.add(arr1[p1++]); // 배열1의 값을 입력 후, 포인터 증감연산자 사용
            } else {
                answer.add(arr2[p2++]);
            }
        }

        // 다른 배열의 길이 남은 경우에
        while(p1<n){
            answer.add(arr1[p1++]);
        }
        while(p2<m){
            answer.add(arr2[p2++]);
        }

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){

            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr1 = {1,3,5};
        int[] arr2 = {2,3,6,7,9};
        System.out.println(T.solution(arr1,arr2));
    }
}
