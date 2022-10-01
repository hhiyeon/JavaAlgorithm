package 자료구조.크레인인형뽑기3;

import java.util.Stack;

public class Solution {
    public static int solution(int[][] board, int[] moves){
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int i=0; i<moves.length; i++){
            int idx = moves[i]-1;
            for(int a=0; a<board.length; a++){
                if(board[a][idx]!=0){
                    int temp = board[a][idx];
                    board[a][idx] = 0;
                    if(!stack.isEmpty() && temp==stack.peek()){
                        answer+=2;
                        stack.pop();
                    } else {
                        stack.add(temp);
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };

        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(T.solution(board,moves));
    }
}
