package DFSBFS기초.경로탐색_인접리스트13;
// 개수가 많아지면 인접행렬로 하기엔 좀 그래요. -> 인접리스트
// 10000 X 10000
// 1~n번 리스트 만들어두기
// 1 2 // 1번에 이어진 2번을 1번 리스트에 이어주기
// 1 2 3 4 // 3번도 이어져있으니까 이어주기 4번도
//

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n){
            answer++;
        } else {
            for(int nv : graph.get(v)){ // v번 arrayList
                if(ch[nv]==0){
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        n = 5;
        m = 9;
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
