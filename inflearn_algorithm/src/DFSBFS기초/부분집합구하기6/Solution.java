package DFSBFS기초.부분집합구하기6;

// 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하시오.
public class Solution {
    static int n;
    static int[] ch; // check 배열 : 부분집합으로 사용할지 안할지 체크
    public void DFS(int L){
        if(L==n+1){
            String temp = "";
            for(int i=1; i<=n; i++){
                if(ch[i]==1) temp+=(i+" "); // check
            }

            if(temp.length()>0) System.out.println(temp); // 공집합 출력 X

        } else {
            ch[L] = 1; // 사용 O
            DFS(L+1); // 왼쪽 = 사용
            ch[L] = 0; // 사용 X
            DFS(L+1); // 오른쪽 = 사용 X
        }
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        n = 3;
        ch = new int[n+1];
        T.DFS(1);
    }
}
