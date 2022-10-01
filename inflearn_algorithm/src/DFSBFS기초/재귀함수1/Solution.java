package DFSBFS기초.재귀함수1;

// 자연수 N이 입력되면 재귀함수를 이용해서 1부터 N까지 출력하는 프로그램을 작성해라.
public class Solution {
    public void DFS(int n){
        if(n==0) return;
        else {
            DFS(n-1);
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.DFS(3);
    }
}
