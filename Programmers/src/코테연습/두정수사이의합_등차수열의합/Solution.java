package 코테연습.두정수사이의합_등차수열의합;

public class Solution {
    public long solution(int a, int b){
        return sumAtoB(Math.min(a,b), Math.max(a,b));
    }
    public long sumAtoB(long min, long max){
        return (max-min +1) * (min+max) /2;
    }
}
