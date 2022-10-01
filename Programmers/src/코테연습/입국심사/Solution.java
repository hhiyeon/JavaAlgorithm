package 코테연습.입국심사;
/*
* n명이 줄 서있고, 비어 있는 곳 가서 심사 받을 수 있음.
입국심사기다리는 사람 n명, 각 심사관이 심사하는데 걸리는 시간 배열 times
모든 사람이 심사 받는데 걸리는 시간의 최솟값
1. 이분탐색은 오름차순으로 정렬되어야 한다.
2. 중간값부터 탐색
3. 왼쪽과 오른쪽 포인터가 방향이 바뀌면 탐색종료
* */
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long lt=0;
        long rt=Long.MAX_VALUE;
        long sum;// 주어진 시간동안 심사받을 수 있는 사람 수

        Arrays.sort(times);
        while(lt<=rt){ // 왼쪽이 오른쪽으로 가면 해제
            long mid = (lt+rt)/2;
            sum = 0;
            for(int i=0; i<times.length; i++){
                sum+= mid/times[i];
                if(sum>=n){
                    break;
                }
            }
            if(n>sum){
                lt = mid +1;
            } else if(n<sum){
                rt = mid -1;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 6;
        int[] times = {7,10};
        System.out.println(T.solution(n,times));
    }
}
