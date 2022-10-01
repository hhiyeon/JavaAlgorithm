package DFSBFS기초.팩토리얼3;

public class Solution {
    public static int DFS(int n){
        if(n==1) return 1;
        else {
            return n*DFS(n-1);
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.DFS(5));
    }
}
