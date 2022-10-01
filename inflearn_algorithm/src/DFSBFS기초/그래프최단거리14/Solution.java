package DFSBFS기초.그래프최단거리14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
 */

// dis[nv] = dis[v]+1
public class Solution {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch, dis;
    public static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                int x = queue.poll();
                if(ch[x]==0){
                    ch[x] =1;
                    queue.offer(x);
                    dis[x] = dis[i] +1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        n = 6;
        m = 9;
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        dis = new int[n+1];
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
        }
        ch[1] =1;
        T.BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+dis[i]);
        }

    }
}
