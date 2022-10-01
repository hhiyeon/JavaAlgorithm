package 코테연습.일이사나라의숫자;

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4","1","2"};

        while(n>0){
            int remain = n%3;
            n /=3;
            System.out.println(remain+ " "+n);

            if(remain==0){
                n--;
            }
            answer = numbers[remain] + answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(10));
    }
}
