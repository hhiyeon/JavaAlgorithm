package 정렬.HIndex;
import java.util.*;
import java.io.*;

/* 논문 n 개
h번 이상 인용된 논문 h편 이상이고 나머지 논문이 h번 이하 인용되면
h의 최대값이 H-Index
배열 citations : 논문 인용 횟수를 담은 배열
*
* */

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        // 0 1 3 5 6
        Arrays.sort(citations); // 오름차순 정렬

        // n개의 논문 중에 h번 이상 인용된 논문이 h편 이상일 경우 h의 최대값 = h-index
        for(int i=0; i<citations.length; i++){
            int h = citations.length-i;
            // 5이 0 이상인지?
            // 4가 1 이상인지?
            // 3이 3 이상인지? O
            if(citations[i]>=h){
                answer = h; // h-index = 3
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(T.solution(citations));
    }
}
