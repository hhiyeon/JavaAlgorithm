package 코테연습.정수제곱근판별;

class Solution {
    public long solution(long n) {
        long answer = 0;
        double x = Math.sqrt(n);

        if(x % 1 == 0){ // 정수는 1로 나누면 항상 나머지가 0 이다.
            answer = (long) ((x+1)*(x+1));
        } else {
            answer = -1;
        }
        return answer;
    }
}