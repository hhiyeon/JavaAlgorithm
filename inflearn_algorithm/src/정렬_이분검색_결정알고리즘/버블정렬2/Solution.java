package 정렬_이분검색_결정알고리즘.버블정렬2;

public class Solution {
    public static int[] solution(int[] arr){
        int[] answer = new int[arr.length];
        int n = arr.length;

        // 반복문 범위 복습하기
        for(int i=0; i< n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i=0; i<arr.length; i++){
            answer[i] = arr[i];
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {13,5,11,7,23,15};
        System.out.println(T.solution(arr));
    }
}
