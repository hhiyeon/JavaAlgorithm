package 배열.격자판최대합9;

public class Main {
    public static int solution(int[][] board){
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;

        for(int i=0; i<board.length; i++){
            sum1=sum2=0;
            for(int j=0; j<board.length; j++){
                sum1 += board[i][j]; // 행의 합
                sum2 += board[j][i]; // 열의 합
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1=sum2=0;

        // 대각선의 합
        for(int i=0; i<board.length; i++){
            sum1 += board[i][i];
            sum2 += board[i][board.length-i-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int[][] arr =
                {{10, 13, 10, 12, 15},
                {12, 39, 30, 23, 11},
                {11, 25, 50, 53, 15},
                {19, 27, 29, 37, 27},
                {19, 13, 30, 13, 19}};
        System.out.println(T.solution(arr));
    }
}
