package 배열.점수계산7;

public class Main {
    public static int solution(int[] num){
        int answer = 0;
        int prev = 0;
        int count = 0;
        for(int i=0; i<num.length; i++){
            if(num[i]==1){
                prev = 1;
                count++;
                answer += count*prev;
            } else {
                prev = 0;
                count=0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 0}));
    }
}
