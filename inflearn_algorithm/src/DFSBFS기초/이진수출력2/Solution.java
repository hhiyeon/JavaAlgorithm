package DFSBFS기초.이진수출력2;
// 재귀함수를 이용해서 10진수를 2진수로 바꿔주기
public class Solution {
    public void DFS(int n){
        if(n==0) return;
        else {
            // System.out.print(n%2); 1101으로 출력됨
            DFS(n/2); // 스택프레임으로 인해서 1011으로 출력됨
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.DFS(11);
    }
}
