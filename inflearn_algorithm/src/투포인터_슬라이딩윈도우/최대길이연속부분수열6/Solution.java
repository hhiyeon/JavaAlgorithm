package 투포인터_슬라이딩윈도우.최대길이연속부분수열6;

// 길이가 N 수열
// 최대 K번을 0을 1으로 변경 가능
// 1로만 구성된 최대 길이의 연속 부분 수열을 찾아서 최대 길이 출력
public class Solution {
    public static int solution(int[] arr, int k){
        int N = arr.length; // 길이는 : rt - lt + 1
        int count = 0, lt=0;
        int answer = 0;

        for(int rt=0; rt<arr.length; rt++){
            if(arr[rt]==0) count++;
            while(count>k){
                if(arr[lt]==0) count--;
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1,1,0,0,1,1,0,1,1,0,1,1,0,1};
        System.out.println(T.solution(arr, 2));
    }
}
