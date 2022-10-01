package DFSBFS기초.피보나치재귀4;
// 피보나치 수열 출력 : 앞의 2개의 수를 합해서 다음 숫자가 되는 수열
// 입력은 피보나치 수열의 총 항의 수
// 만약 7이 입력되면 1 1 2 3 5 8 13 출력
public class Solution {
    static int[] fibo; // 배열에 저장해서 개선하는 방법
    public static int DFS(int n){
        if(fibo[n]>0) return fibo[n]; // 0보다 크다는건 그 값이 이미 있다는 뜻
        if(n==1) return fibo[n]= 1;
        else if(n==2) return fibo[n]=1;
        else return fibo[n] = DFS(n-2)+DFS(n-1);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 45;
        fibo = new int[n+1]; // 0번 인덱스 필요없이 1~10번
        T.DFS(n); // 한 번 돌리고 값들을 배열에 저장해준다.
        for(int i=1; i<=n; i++) System.out.print(fibo[i]+" "); // fibo만 출력
    }
}
