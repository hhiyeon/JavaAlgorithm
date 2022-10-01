package 코테연습.최소직사각형;

import java.util.Arrays;
import java.util.Comparator;

//
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxA = 0;
        int maxB = 0;

        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1]){ // 긴 부분을 가로로 배치
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }

        for(int i=0; i<sizes.length; i++){
            maxA = Math.max(maxA, sizes[i][0]);
            maxB = Math.max(maxB, sizes[i][1]);
        }

        answer = maxA*maxB;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] s = {{60,50},{30,70},{60,30},{80,40}};
    }
}
