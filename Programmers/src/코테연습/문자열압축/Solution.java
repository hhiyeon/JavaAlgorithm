package 코테연습.문자열압축;

import java.util.ArrayList;

// aabbaccc -> 2a2ba3c로 표현 : 압축률이 낮을 수 있다는 리스크
// ababcdcd -> ab ab cd cd 2개씩 자르기
// 문자열을 잘라서 압축을 했을 시에 가장 짧은 문자열 길이를 구해라
class Solution {
    public int solution(String s) {
        int answer = 0;
        int maxCompactLength = s.length()/2;
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=maxCompactLength; i++){
            min = Math.min(stringCompact(i, s), min);
        }
        answer = min;
        return answer;
    }
    public static int stringCompact(int compactSize, String s){
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("", compactSize);

        String comp1 = arr[0];
        int count = 1;
        for(int i=1; i<arr.length; i++){
            String comp2 = arr[i];
            System.out.println(comp2);
            if(!comp1.equals(comp2)){
                sb.append(count);
                sb.append(comp1);
                count = 0;
                comp1 = comp2;
            } else {
                count++;
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String s = "aabbaccc";
        System.out.println(T.solution(s));
    }
}

// 2a2ba3c