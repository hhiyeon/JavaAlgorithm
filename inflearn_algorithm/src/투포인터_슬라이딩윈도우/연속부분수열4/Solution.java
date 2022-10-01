package 투포인터_슬라이딩윈도우.연속부분수열4;

// 투포인터는 n^2 -> n으로 개선
// N개의 수열에서 특정 숫자 M이 되는 경우의 수를 구하시오
// N = 8, M = 6
// 1 2 1 3 1 1 1 2
// 합이 6이 되는 연속 부분 수열은 2,1,3 / 1,3,1,1 / 3,1,1,1 으로 답이 3
public class Solution {
    public static int solution(int[] arr, int N, int M){
        int answer = 0, sum =0;
        int lt=0;

        // sum이 M보다 크면 lt를 빼주고 lt++
        // sum이 M보다 작으면 rt++

        for(int rt=0; rt<N; rt++){ // 1. 증가
            sum+= arr[rt]; // 2. 더하기
            if(sum==M) answer++; // 3. 확인

            // sum이 M보다 커지면 삭제
            while(sum>=M){
                sum -= arr[lt++];
                if(sum==M){
                    answer++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int N = 8;
        int M = 6;
        int[] arr = {1,2,1,3,1,1,1,2};

        System.out.println(T.solution(arr, N, M));
    }
}
