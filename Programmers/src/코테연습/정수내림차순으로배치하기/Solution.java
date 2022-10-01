package 코테연습.정수내림차순으로배치하기;

import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;

        String str = String.valueOf(n);
        String[] arr = str.split("");
        Arrays.sort(arr, Collections.reverseOrder());

        str = "";
        for(int i = 0; i<arr.length; i++){
            str += arr[i];
        }
        answer = Long.parseLong(str);
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(118372));
    }
}