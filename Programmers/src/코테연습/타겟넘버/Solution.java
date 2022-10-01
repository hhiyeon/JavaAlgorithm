package 코테연습.타겟넘버;
// n이 음이 아닌 정수들
// 순서를 바꾸지 않고 더하거나 빼서 넘버 만들기
// -> 경우의 수를 구하는 문제 -> DFS

// 루트 만들고 자식으로 말단가기까지 내려갔다가 다시 올라오기
// 경우의 수 - 빼거나 더하거나
class Solution {
    public void dfs(int[] numbers, int target, int depth, int res){
        if(depth== numbers.length){

        }
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int[] check = {};

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] n = {1,1,1,1,1};
        int target = 3;
        System.out.println(T.solution(n, target));
    }
}