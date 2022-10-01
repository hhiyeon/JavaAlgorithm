package 투포인터_슬라이딩윈도우.연속된자연수의합5;

// N 입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력해라
// N = 15
// 7 + 8 = 15;
// 4 + 5 + 6 = 15;
// 1 + 2 + 3 + 4 + 5 = 15
public class Solution {
    public static int solution(int N){
        int answer = 0;
        int sum = 0, lt =0;
        int m=N/2+1;
        int[] arr = new int[m];

        for(int i=0; i<m; i++){
            arr[i] = i+1;
            //System.out.println(arr[i]);
        }

        for(int rt=0; rt<m; rt++){
            sum +=arr[rt];

            if(sum==N){
                answer++;
            }
            while(sum>=N){
                sum-=arr[lt++];
                if(sum==N){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 15;
        System.out.println(T.solution(n));
    }
}
