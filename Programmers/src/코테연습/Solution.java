package 코테연습;

import java.util.*;
class Solution {
    public String solution(int[] arr) {
        String answer = "";
        StringBuffer sb = new StringBuffer();

        // 오름차순 정렬
        Arrays.sort(arr);

        // 내림차순 정렬
        Arrays.sort(arr); // 오름차순 정렬 후
        for(int i=0; i<arr.length/2; i++){ // 순서를 뒤집어준다.
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+ " ");
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T =new Solution();
        int[] arr = {1,2,5,7,3,9,10};
        System.out.println(T.solution(arr));
    }
}