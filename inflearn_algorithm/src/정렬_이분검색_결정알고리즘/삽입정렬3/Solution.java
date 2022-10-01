package 정렬_이분검색_결정알고리즘.삽입정렬3;

public class Solution {
    public static int[] solution(int[] arr){
        int[] answer = new int[arr.length];

        for(int i=1; i<arr.length; i++){
            int temp = arr[i],j;
            for(j=i-1; j>=0; j--){
                if(arr[j]>temp){
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = temp;
        }

        for(int i=0; i<arr.length; i++){
            answer[i] = arr[i];
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {11,7,5,6,10,9};
        System.out.println(T.solution(arr));
    }
}
