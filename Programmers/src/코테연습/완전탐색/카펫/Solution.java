package 코테연습.완전탐색.카펫;

/* 중앙은 노란색 테두리는 갈색
카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
brown + yellow = 가로*세로

* */
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for(int i=3; i<=sum; i++){
            int sero = i; // 세로
            int garo = sum / sero; // 가로

            if(garo<3){
                continue;
            }
            if(garo>=sero){
                if((garo-2)*(sero-2)==yellow){
                    answer[0] = garo;
                    answer[1] = sero;
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int brown = 10;
        int yellow = 2;
        System.out.println(T.solution(brown, yellow));
    }
}
