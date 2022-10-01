package 코테연습.소수찾기;

class Solution {
    public int solution(int n) {
        boolean prime[] = new boolean[n+1];
        int answer = 0;

        prime[0] = prime[1] = true;
        for(int i=2; i*i<=n; i++){
            if(!prime[i]){
                for(int j=i*i; j<=n; j+=i){
                    prime[j] = true;
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(!prime[i]){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T =new Solution();
        System.out.println(T.solution(10));
    }
}
