package 투포인터_슬라이딩윈도우.최대매출3;

// N일 동안의 매출 기록을 준다.
// 연속된 K일 동안의 최대 매출액이 얼마인지 구해라
// 12 15 11 20 25 10 20 19 13 15
// 이 중에서 11 20 25 을 더한 값이 56만원으로 최대값이 된다.
public class Solution {
    public static int solution(int[] arr, int k){
        int answer = 0;
        int sum = 0;

        // 일단 맨 첫번째부터 k번째 값들을 다 더해준다.
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        answer = sum;

        // k부터 배열의 마지막까지 계산해본다.
        for(int i=k; i<arr.length; i++){
            sum+=(arr[i]-arr[i-k]); // 현재 값을 더해주고 맨 앞의 값을 지워준다.
            answer = Math.max(answer, sum); // 이전의 총합과 현재의 총합을 비교해줘서 최대값을 저장
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {12,15,11,20,25,10,20,19,13,15};
        System.out.println(T.solution(arr, 3));
    }
}
