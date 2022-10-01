package 정렬_이분검색_결정알고리즘.선택정렬1;

public class Solution {
    public static int[] solution(int[] arr){
        int[] answer = new int[arr.length];
        int min = Integer.MAX_VALUE;
        int idx = 0;

        for(int i=0; i<arr.length; i++){
            min = Integer.MAX_VALUE;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    idx = j;
                }
            }

            // 교체
            int temp = arr[i];
            arr[i] = min;
            arr[idx] = temp;
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
