package 코테연습.피보나치수;

class Solution {
    static int sum = 0;
    public int solution(int n) {
        int answer = 0;
        int start = 0;
        int fibo = 1;

        if(n==1 || n==0){
            return 1;
        }
        for(int i=2; i<=n; i++){
            answer = (start+fibo)%1234567;
            start = fibo;
            fibo = answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T= new Solution();
        System.out.println(T.solution(5));
    }
}
