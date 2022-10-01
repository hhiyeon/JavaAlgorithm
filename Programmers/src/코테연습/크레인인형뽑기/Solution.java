package 코테연습.크레인인형뽑기;

import java.util.Stack;

/* N X N 격자
위쪽 크레인, 오른쪽 바구니
인형을 바구니에 넣는데, 같은거 2개이상이면 사라짐
인형이없는 곳에서 크레인을 작동시키면, 아무런 일도 일어나지 않는다.
크레인을 모두 작동시킨 후 사라진 인형의 개수 출력
* */
class Solution {
    static int removeCount = 0;
    static int removeDoll;
    static Stack<Integer> stack = new Stack<>();
    public int solution(int[][] board, int[] moves) {

        for(int removeIdx : moves){
            for (int i = 0; i < board.length; i++) {
                if (board[i][removeIdx-1] != 0) {
                    removeDoll = board[i][removeIdx - 1];
                    if(!stack.isEmpty()){
                        if (stack.peek() == removeDoll) {
                            stack.pop();
                            removeCount = removeCount + 2;
                        } else {
                            stack.add(removeDoll);
                        }
                        board[i][removeIdx-1] = 0;
                        break;
                    } else {
                        stack.add(removeDoll);
                        board[i][removeIdx-1] = 0;
                        break;
                    }
                }
            }
        }
        return removeCount;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] b = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(T.solution(b, moves));
    }
}
