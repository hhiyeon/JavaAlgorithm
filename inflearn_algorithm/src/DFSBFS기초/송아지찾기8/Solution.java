package DFSBFS기초.송아지찾기8;
// 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면
// 현수는 현재 위치에서 송아지의 위치까지 이동한다.
// 송아지는 안움직인다.
// 현수는 한번 점프로 앞으로 1 뒤로 1 앞으로 5 이동 가능
// 최소 몇번의 점프로 현수가 송아지의 위치로 갈수있는지 구해라

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] dis = {1, -1, 5};
    int[] ch; // 체크 배열
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e){
        ch = new int[10001]; // 좌표는 1부터 10000까지
        ch[s] = 1; // 방문 체크
        Q.offer(s); // root 노드
        int L = 0; // 레벨 0에서 시작
        while(!Q.isEmpty()){
            int len = Q.size(); // 큐의 크기 = 레벨에 있는 원소
            for(int i=0; i<len; i++){
                int x = Q.poll(); // 레벨에 있는 노드 꺼내주기
                //if(x==e) return L; // 송아지 찾는 방법 1 : 레벨에 송아지의 위치가 존재하면 return
                for(int j=0; j<3; j++){ // 이동할 수 있는 3가지 경우의 수
                    int nx = x + dis[j]; // 현재노드 + 이동거리 = 이동한 노드의 위치
                    if(nx==e) return L+1; // 송아지 찾는 방법 2 : 다음 레벨에 송아지가 있다는 뜻
                    if(nx>=1 && nx<=10000 && ch[nx]==0){
                        // 범위에서 벗어나지 않고, 방문 체크 안한곳만
                        Q.offer(nx);
                    }
                }
            }
            // for문 종료되면 레벨 증가
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int s = 5;
        int e = 14;
        System.out.println(T.BFS(s, e));
    }
}
